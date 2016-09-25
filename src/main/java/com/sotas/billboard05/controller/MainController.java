package com.sotas.billboard05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
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
}
