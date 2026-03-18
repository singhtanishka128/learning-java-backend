package com.kenny.JobApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("testing console");
        return "index";
    }
}
