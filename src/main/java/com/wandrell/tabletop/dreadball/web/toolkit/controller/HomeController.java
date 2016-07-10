
package com.wandrell.tabletop.dreadball.web.toolkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final String PATH_WELCOME = "welcome";

    public HomeController() {
        super();
    }

    @RequestMapping("/")
    public String showIndex() {
        return PATH_WELCOME;
    }

}
