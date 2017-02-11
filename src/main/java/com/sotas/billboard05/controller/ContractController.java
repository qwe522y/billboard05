package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.ContractDto;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;
import com.sotas.billboard05.service.*;
import com.sotas.billboard05.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/agent/contract")
public class ContractController {
    private ContractService service;
    private AuthUserService authUserService;
    private TimetableService timetableService;
    private BillboardSideService billboardSideService;
    private BillboardService billboardService;

    @Autowired
    public ContractController(ContractService service, AuthUserService authUserService, TimetableService timetableService, BillboardSideService billboardSideService, BillboardService billboardService) {
        this.service = service;
        this.authUserService = authUserService;
        this.timetableService = timetableService;
        this.billboardSideService = billboardSideService;
        this.billboardService = billboardService;
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String list(Model model) {
        AuthUser authUser = authUserService.getAuthUser();
        Calendar cal = Calendar.getInstance();
        List<ContractDto> contracts = service.getByAgentId(authUser.getAgent().getId(), cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
        List<ContractDto> filtered = contracts.stream().filter(c -> c.getE().getStatus() == Contract.Status.NEW).collect(Collectors.toList());
        model.addAttribute("contracts", filtered);
        return "contract/list";
    }

    @RequestMapping(value = "{contractId}/accept", method = RequestMethod.GET)
    public String accept(@PathVariable int contractId) {
        checkAccess(contractId);
        Contract contract = service.get(contractId);
        service.accept(contract);
        return "redirect:/agent/contract/";
    }

    @RequestMapping(value = "{contractId}/reject", method = RequestMethod.GET)
    public String reject(@PathVariable int contractId) {
        checkAccess(contractId);
        Contract contract = service.get(contractId);
        service.reject(contract);
        return "redirect:/agent/contract/";
    }

    private void checkAccess(int contractId) {
        Contract contract = service.get(contractId);
        Timetable timetable = timetableService.get(contract.getTimetableId());
        BillboardSide bbSide = billboardSideService.get(timetable.getSideId());
        Utils.checkAccess(billboardService.get(bbSide.getBillboardId()), authUserService.getAuthUser());
    }
}
