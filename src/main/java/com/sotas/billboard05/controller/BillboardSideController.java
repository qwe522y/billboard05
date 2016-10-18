package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.service.AuthUserService;
import com.sotas.billboard05.service.BillboardService;
import com.sotas.billboard05.service.BillboardSideService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/agent/side")
public class BillboardSideController {
    private static final Logger log = Logger.getLogger(BillboardSideController.class);
    private static final char[] alphabet = "ABCDEFGH".toCharArray();
    @Autowired
    private BillboardSideService billboardSideService;
    @Autowired
    private BillboardService billboardService;
    @Autowired
    private AuthUserService authUserService;

    @RequestMapping(value = "{billboardId}/", method = RequestMethod.GET)
    public String list(@PathVariable int billboardId, Model model) {
        model.addAttribute("list", billboardSideService.getByBillboard(billboardId));
        return "billboard_side/list";
    }

    @RequestMapping(value = "{billboardId}/", method = RequestMethod.POST)
    public String addBillboardSide(@PathVariable int billboardId, BillboardSide billboardSide) {
        checkAccess(billboardService.get(billboardId), authUserService.getAuthUser());
        billboardSide.setBillboardId(billboardId);
        billboardSideService.add(billboardSide);
        return "redirect:/agent/side/" + billboardId + "/";
    }

    @RequestMapping(value = "{billboardId}/{billboardSideId}/", method = RequestMethod.POST)
    public String editBillboardSide(@PathVariable int billboardId, @PathVariable int billboardSideId, BillboardSide billboardSide) {
        checkAccess(billboardService.get(billboardId), authUserService.getAuthUser());
        billboardSide.setBillboardId(billboardId);
        billboardSide.setId(billboardSideId);
        billboardSideService.update(billboardSide);
        return "redirect:/agent/side/" + billboardId + "/";
    }

    @RequestMapping(value = "{billboardId}/add", method = RequestMethod.GET)
    public String showAddForm(@PathVariable int billboardId, Model model) {
        checkAccess(billboardService.get(billboardId), authUserService.getAuthUser());

        List<BillboardSide> sides = billboardSideService.getByBillboard(billboardId);
        List<String> names = new ArrayList<>();
        for(Character c : alphabet) {
            boolean flag = false;
            for(BillboardSide side : sides) {
                if(c.toString().equals(side.getName())) {
                    flag = true;
                    break;
                }
            }
            if(!flag) names.add(c.toString());
        }
        model.addAttribute("names", names);
        model.addAttribute("entity", new BillboardSide());
        model.addAttribute("billboard", billboardService.get(billboardId));
        return "billboard_side/add_form";
    }

    @RequestMapping(value = "{bbId}/{bbSideId}/edit", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("bbId") int billboardId, @PathVariable("bbSideId") int billboardSideId, Model model) {
        checkAccess(billboardService.get(billboardId), authUserService.getAuthUser());
        BillboardSide currentSide = billboardSideService.get(billboardSideId);
        List<BillboardSide> sides = billboardSideService.getByBillboard(billboardId);
        List<String> names = new ArrayList<>();
        for(Character c : alphabet) {
            boolean flag = false;
            for(BillboardSide side : sides) {
                if(side.getId() == currentSide.getId()) continue;
                if(c.toString().equals(side.getName())) {
                    flag = true;
                    break;
                }
            }
            if(!flag) names.add(c.toString());
        }
        model.addAttribute("names", names);
        model.addAttribute("entity", currentSide);
        model.addAttribute("billboard", billboardService.get(billboardId));
        return "billboard_side/edit_form";
    }

    private void checkAccess(Billboard billboard, AuthUser authUser) {
        if(billboard.getAgentId() != authUser.getAgent().getId()) {
            String msg = "billboard.agentId=" + billboard.getAgentId() + " authUser.agent.id=" + authUser.getAgent().getId();
            log.fatal(msg);
            throw new RuntimeException(msg);
        }
    }
}
