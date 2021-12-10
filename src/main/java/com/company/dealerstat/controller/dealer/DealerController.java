package com.company.dealerstat.controller.dealer;

import com.company.dealerstat.controller.ControllerUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/id{dealerId}")
@AllArgsConstructor
public class DealerController {

    private ControllerUtility controllerUtility;

    @GetMapping("/dealers")
    public ModelAndView showDealers() {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewDealersPage(
                "dealer/showEntities/dealers");
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView showDealerWithId(@PathVariable("id") String id) {

        int dealerId = controllerUtility.sessionDealerId();
        ModelAndView modelAndView = controllerUtility.viewDealerWithId(
                "dealer/entity/dealer", id);
        modelAndView.addObject("dealerId", dealerId);
        return modelAndView;
    }
}