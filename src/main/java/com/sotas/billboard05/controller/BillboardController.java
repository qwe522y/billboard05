package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.repository.BillboardFormatRepository;
import com.sotas.billboard05.repository.BillboardTypeRepository;
import com.sotas.billboard05.repository.CityRepository;
import com.sotas.billboard05.service.AuthUserService;
import com.sotas.billboard05.service.BillboardService;
import com.sotas.billboard05.service.BillboardSideService;
import com.sotas.billboard05.service.OwnerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/agent/")
public class BillboardController {
    private static Logger log = Logger.getLogger(BillboardController.class);
    private static final char[] alphabet = "ABCDEFGH".toCharArray();
    @Autowired
    private BillboardSideService billboardSideService;
    @Autowired
    private BillboardService billboardService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private AuthUserService authUserService;
    @Autowired
    private BillboardTypeRepository billboardTypeRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private BillboardFormatRepository billboardFormatRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        List<BillboardDto> list = billboardService.getListByAgent(authUser.getAgent().getId());
        model.addAttribute("billboards", list);
        return "billboard/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        model.addAttribute("cities", cityRepository.getAll());
        model.addAttribute("owners", ownerService.getByAgent(authUser.getAgent().getId()));
        model.addAttribute("billboardTypes", billboardTypeRepository.getAll());
        model.addAttribute("billboardFormats", billboardFormatRepository.getAll());
        model.addAttribute("billboard", new Billboard());
        return "billboard/add_form";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBillboard(Model model, int sideNum, BigDecimal rent, Billboard billboard) {
        AuthUser authUser = authUserService.getAuthUser();
        billboard.setAgentId(authUser.getAgent().getId());
        billboard = billboardService.add(billboard);
        if(sideNum <= alphabet.length) {
            for (int i = 0; i < sideNum; i++) {
                BillboardSide side = new BillboardSide(billboard.getId(), "" + alphabet[i], rent, 1);
                billboardSideService.add(side);
            }
        } else {
            log.warn("sideNum <= alphabet.length is false");
        }
        return "redirect:side/" + billboard.getId() + "/";
    }
}
