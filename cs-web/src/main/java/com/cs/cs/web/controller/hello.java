package com.cs.cs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fengbo on 17/10/24.
 */
@Controller
@RequestMapping("/hello")
public class hello {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model){
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

}
