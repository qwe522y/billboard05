package com.sotas.billboard05.controller;

import com.sotas.billboard05.service.BillboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/agent/")
public class AgentController {
    private BillboardService billboardService;

    @Autowired
    public AgentController(BillboardService billboardService) {
        this.billboardService = billboardService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        return "agent";
    }


}
