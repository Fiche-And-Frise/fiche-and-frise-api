package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.UserRegistrationDto;
import com.platine.fiche_frise_api.config.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping("")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public ModelAndView showRegistrationForm(){
        var modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        myUserDetailsService.saveNewUser(registrationDto);
        return new ModelAndView("redirect:/user/registration?success");
    }
}
