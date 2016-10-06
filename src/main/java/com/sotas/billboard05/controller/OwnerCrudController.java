package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.entity.Owner;
import com.sotas.billboard05.service.AuthUserService;
import com.sotas.billboard05.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/agent/owner/")
public class OwnerCrudController {
    private AuthUserService authUserService;
    private OwnerService ownerService;

    @Autowired
    public OwnerCrudController(AuthUserService authUserService, OwnerService ownerService) {
        this.authUserService = authUserService;
        this.ownerService = ownerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        List<Owner> owners = ownerService.getByAgent(authUser.getAgent().getId());
        model.addAttribute("owners", owners);
        return "owner/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/add_form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(Owner owner) {
        AuthUser authUser = authUserService.getAuthUser();
        owner.setAgentId(authUser.getAgent().getId());
        ownerService.add(owner);
        return "redirect:.";
    }
}
