package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.repository.BillboardTypeRepository;
import com.sotas.billboard05.repository.CityRepository;
import com.sotas.billboard05.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/agent/")
public class AgentController {
    private BillboardService billboardService;
    private BillboardTypeRepository billboardTypeRepository;
    private CityRepository cityRepository;
    private OwnerService ownerService;
    private AuthUserService authUserService;

    @Autowired
    public AgentController(BillboardService billboardService, BillboardTypeRepository billboardTypeRepository, CityRepository cityRepository, OwnerService ownerService, AuthUserService authUserService) {
        this.billboardService = billboardService;
        this.billboardTypeRepository = billboardTypeRepository;
        this.cityRepository = cityRepository;
        this.ownerService = ownerService;
        this.authUserService = authUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        List<BillboardDto> list = billboardService.getListByAgent(authUser.getAgent().getId());
        model.addAttribute("billboards", list);
        return "agent/main";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("cities", cityRepository.getAll());
        model.addAttribute("owners", ownerService.getAll());
        model.addAttribute("billboardTypes", billboardTypeRepository.getAll());
        model.addAttribute("billboard", new Billboard());
        return "agent/add_form";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBillboard(Model model, Billboard billboard) {
        AuthUser authUser = authUserService.getAuthUser();
        billboard.setLocation("test");
        billboard.setAgentId(authUser.getAgent().getId());
        billboardService.add(billboard);
        return "redirect:.";
    }
}
