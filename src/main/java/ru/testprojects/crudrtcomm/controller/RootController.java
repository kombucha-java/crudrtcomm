package ru.testprojects.crudrtcomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/main")
    public String root() {
        return "main";
    }
}
