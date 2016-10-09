package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.repository.BillboardFormatRepository;
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
public class BillboardController {
    private BillboardService billboardService;
    private OwnerService ownerService;
    private AuthUserService authUserService;
    private BillboardTypeRepository billboardTypeRepository;
    private CityRepository cityRepository;
    private BillboardFormatRepository billboardFormatRepository;

    @Autowired
    public BillboardController(BillboardService billboardService, OwnerService ownerService, AuthUserService authUserService, BillboardTypeRepository billboardTypeRepository, CityRepository cityRepository, BillboardFormatRepository billboardFormatRepository) {
        this.billboardService = billboardService;
        this.ownerService = ownerService;
        this.authUserService = authUserService;
        this.billboardTypeRepository = billboardTypeRepository;
        this.cityRepository = cityRepository;
        this.billboardFormatRepository = billboardFormatRepository;
    }

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
    public String addBillboard(Model model, Billboard billboard, String qwe_________________________________) {
        AuthUser authUser = authUserService.getAuthUser();
        billboard.setLocation("test");
        billboard.setAgentId(authUser.getAgent().getId());
        billboardService.add(billboard);
        return "redirect:.";
    }
}
