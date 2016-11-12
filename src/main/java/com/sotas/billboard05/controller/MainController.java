package com.sotas.billboard05.controller;

import com.sotas.billboard05.SessionMsg;
import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.repository.CityRepository;
import com.sotas.billboard05.service.*;
import com.sotas.billboard05.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private BillboardService billboardService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TimetableService timetableService;
    @Autowired
    private BillboardSideService billboardSideService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private SessionMsgProvider sessionMsgProvider;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("billboards", billboardService.getAll());
        model.addAttribute("cities", cityRepository.getAll());
        return "home";
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
        model.addAttribute("sides", sidesDto);
        model.addAttribute("months", Utils.genMonth(new Date(), 3));
        model.addAttribute("billboard", billboardService.get(bbId));
        return "bb_detail";
    }

    @RequestMapping(value = "contract", method = RequestMethod.POST)
    public String contract(int sideId, int surfaceId, int year, int month, String phone) {
        Timetable tt = timetableService.getByUniq(sideId, surfaceId, year, month);
        if(tt == null) {
            tt = new Timetable(sideId, surfaceId, month, year, billboardSideService.get(sideId).getRent(), Timetable.Status.OPEN);
            tt = timetableService.add(tt);
        }
        Contract contract = new Contract(tt.getId(), phone, null);
        contractService.add(contract);
        sessionMsgProvider.push("Заявка принята, ожидайте пока с вами свяжутся", SessionMsg.Status.SUCCESS);
        return "redirect:/";
    }
}
