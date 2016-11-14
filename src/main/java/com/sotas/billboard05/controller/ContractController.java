package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.ContractDto;
import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.service.AuthUserService;
import com.sotas.billboard05.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/agent/contract")
public class ContractController {
    @Autowired
    private ContractService service;
    @Autowired
    private AuthUserService authUserService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        Calendar cal = Calendar.getInstance();
        List<ContractDto> contracts = service.getByAgentId(authUser.getAgent().getId(), cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
        List<ContractDto> filtered = new ArrayList<>();
        for(ContractDto c : contracts) {
            if(c.getE().getStatus() == Contract.Status.NEW)
                filtered.add(c);
        }
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }
}
