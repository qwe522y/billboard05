package com.sotas.billboard05.controller;

import com.sotas.billboard05.SessionMsg;
import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.repository.BillboardFormatRepository;
import com.sotas.billboard05.repository.BillboardTypeRepository;
import com.sotas.billboard05.repository.CityRepository;
import com.sotas.billboard05.service.*;
import com.sotas.billboard05.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {
    private BillboardService billboardService;
    private CityRepository cityRepository;
    private TimetableService timetableService;
    private BillboardSideService billboardSideService;
    private ContractService contractService;
    private BillboardTypeRepository billboardTypeRepository;
    private BillboardFormatRepository billboardFormatRepository;
    private SessionMsgProvider sessionMsgProvider;
    private ImgService imgService;

    @Autowired
    public MainController(BillboardService billboardService, CityRepository cityRepository, TimetableService timetableService, BillboardSideService billboardSideService, ContractService contractService, BillboardTypeRepository billboardTypeRepository, BillboardFormatRepository billboardFormatRepository, SessionMsgProvider sessionMsgProvider, ImgService imgService) {
        this.billboardService = billboardService;
        this.cityRepository = cityRepository;
        this.timetableService = timetableService;
        this.billboardSideService = billboardSideService;
        this.contractService = contractService;
        this.billboardTypeRepository = billboardTypeRepository;
        this.billboardFormatRepository = billboardFormatRepository;
        this.sessionMsgProvider = sessionMsgProvider;
        this.imgService = imgService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        List<BillboardSide> sideList = billboardSideService.getAll();
        Map<Integer, BigDecimal> minRentMap = new HashMap<>();
        BigDecimal absoluteMinRent = null;
        sideList.forEach(x -> {
            if(!minRentMap.containsKey(x.getBillboardId()) || minRentMap.get(x.getBillboardId()).compareTo(x.getRent()) == 1) {
                minRentMap.put(x.getBillboardId(), x.getRent());
            }
        });
        for(BigDecimal v : minRentMap.values()) {
            if(absoluteMinRent == null || v.compareTo(absoluteMinRent) == -1) absoluteMinRent = v;
        };

        Map<Integer, BigDecimal> maxRentMap = new HashMap<>();
        BigDecimal absoluteMaxRent = null;
        sideList.forEach(x -> {
            if(!maxRentMap.containsKey(x.getBillboardId()) || maxRentMap.get(x.getBillboardId()).compareTo(x.getRent()) == -1) {
                maxRentMap.put(x.getBillboardId(), x.getRent());
            }
        });
        for(BigDecimal v : maxRentMap.values()) {
            if(absoluteMaxRent == null || v.compareTo(absoluteMaxRent) == 1) absoluteMaxRent = v;
        };

        model.addAttribute("absoluteMinRent", absoluteMinRent.setScale(0, BigDecimal.ROUND_DOWN));
        model.addAttribute("absoluteMaxRent", absoluteMaxRent.setScale(0, BigDecimal.ROUND_DOWN));
        model.addAttribute("minRentMap", minRentMap);
        model.addAttribute("billboards", billboardService.getAll());
        model.addAttribute("cities", cityRepository.getAll());
        model.addAttribute("billboardTypes", billboardTypeRepository.getAll());
        model.addAttribute("billboardFormats", billboardFormatRepository.getAll());
        return "home";
    }

    @RequestMapping(value = "list")
    public String listView(Model model) {
        home(model);
        return "listing_rows";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginfail")
    public String loginFail() {
        return "redirect:/";
    }

    @RequestMapping(value = "bb/{bbId}")
    public String billboardDetail(@PathVariable int bbId, Model model) {
        Calendar cal = Calendar.getInstance();
        List<BillboardSide> sides = billboardSideService.getByBillboard(bbId);
        ArrayList<TimetableSideDto> sidesDto = new ArrayList<>();
        for(BillboardSide side : sides) {
            sidesDto.add(timetableService.getByBillboardSide(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), side.getId()));
        }
        BigDecimal minRent = sidesDto.size() == 0 ? BigDecimal.ZERO : sidesDto.get(0).getBbSide().getRent();
        for(TimetableSideDto e : sidesDto) {
            BigDecimal rent = e.getBbSide().getRent();
            if(rent.compareTo(minRent) < 0) minRent = rent;
        };
        Billboard bb = billboardService.get(bbId);
        model.addAttribute("minRent", minRent);
        model.addAttribute("sides", sidesDto);
        model.addAttribute("months", Utils.genMonth(new Date(), 6));
        model.addAttribute("billboard", bb);
        model.addAttribute("bbFormat", billboardFormatRepository.get(bb.getFormatId()).getName().toLowerCase());
        model.addAttribute("light", bb.isLight() ? "есть" : "нет");
        model.addAttribute("imgCount", imgService.getImgCount(bbId));
        return "bb_detail";
    }

    @RequestMapping(value = "contract", method = RequestMethod.POST)
    public String contract(int sideId, int surfaceId, int year, int month, String phone, String comment) {
        Timetable tt = timetableService.getByUniq(sideId, surfaceId, year, month);
        if(tt == null) {
            tt = new Timetable(sideId, surfaceId, month, year, billboardSideService.get(sideId).getRent(), Timetable.Status.OPEN);
            tt = timetableService.add(tt);
        }
        Contract contract = new Contract(tt.getId(), phone, comment);
        contractService.add(contract);
        sessionMsgProvider.push("Заявка принята, ожидайте пока с вами свяжутся", SessionMsg.Status.SUCCESS);
        return "redirect:/";
    }

    @RequestMapping(value = "how_it_works", method = RequestMethod.GET)
    public String howItWorks() { return "how_it_works"; }

    @RequestMapping(value = "become_partner", method = RequestMethod.GET)
    public String become_parner() { return "become_partner"; }
}
