package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.UserRegistrationDto;
import com.platine.fiche_frise_api.config.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public ModelAndView showRegistrationForm(){
        return new ModelAndView("registration");
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        myUserDetailsService.saveNewUser(registrationDto);
        return new ModelAndView("redirect:/registration?success");
    }
}
