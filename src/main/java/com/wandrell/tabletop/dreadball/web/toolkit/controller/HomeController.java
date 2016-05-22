package com.wandrell.tabletop.dreadball.web.toolkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    public HomeController() {
    }

    @RequestMapping("/")
    public String showIndex() {
        return "welcome";
    }

}
