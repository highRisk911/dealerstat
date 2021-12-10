package com.company.dealerstat.controller;

import com.company.dealerstat.entity.user.Role;
import com.company.dealerstat.entity.user.User;
import com.company.dealerstat.service.user.UserService;
import com.company.dealerstat.validator.WebAppValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class RegistrationController {

    private UserService userService;

    private PasswordEncoder encoder;

    private WebAppValidator validator;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect";
        }
        if (logout != null) {
            errorMessage = "Logged out successfully";
        }
        modelAndView.setViewName("start/login");
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(model);
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("user", userService.findUser(userEmail));
        modelAndView.setViewName("start/welcome");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login?logout=true");
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start/signUp");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(@ModelAttribute("user") User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        validator.validate(user, result);
        if (result.hasErrors()) {
            modelAndView.setViewName("start/signUp");
            return modelAndView;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(User.DEFAULT_ID);
        user.setRole(Role.ROLE_DEALER);
        user.setCreatedAt(new Date(new java.util.Date().getTime()));
        userService.addUser(user);
        modelAndView.setViewName("redirect:/my" + userService.findUser(user.getEmail()));
        return modelAndView;
    }
}