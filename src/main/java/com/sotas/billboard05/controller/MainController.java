package com.sotas.billboard05.controller;

import com.sotas.billboard05.repository.CityRepository;
import com.sotas.billboard05.service.BillboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private BillboardService billboardService;
    @Autowired
    private CityRepository cityRepository;
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
        model.addAttribute("billboard", billboardService.get(bbId));
        return "bb_detail";
    }
}
