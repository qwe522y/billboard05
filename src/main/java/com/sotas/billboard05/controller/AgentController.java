package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.service.AuthUserService;
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
    private AuthUserService authUserService;

    @Autowired
    public AgentController(BillboardService billboardService, AuthUserService authUserService) {
        this.billboardService = billboardService;
        this.authUserService = authUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        billboardService.getListByCity(authUser.getAgent().getId());
        return "agent";
    }
}
