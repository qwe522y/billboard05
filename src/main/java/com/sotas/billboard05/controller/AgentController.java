package com.sotas.billboard05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/agent/")
public class AgentController {
    @RequestMapping(method = RequestMethod.GET)
    public String agent() {
        return "agent";
    }


}
