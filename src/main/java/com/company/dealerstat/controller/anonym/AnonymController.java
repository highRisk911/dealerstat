package com.company.dealerstat.controller.anonym;

import com.company.dealerstat.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anonym/")
@AllArgsConstructor
public class AnonymController {

    private ControllerUtility controllerUtility;

    @GetMapping("/")
    public ModelAndView index() {
        return controllerUtility.startPage("anonym/start/index");
    }
}