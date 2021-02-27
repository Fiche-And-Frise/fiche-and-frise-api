package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.UserRegistrationDto;
import com.platine.fiche_frise_api.config.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ModelAndView> registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        try {
            myUserDetailsService.loadUserByUsername(registrationDto.getUserName());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ModelAndView("redirect:/registration?error"));
        } catch (Exception e){
            myUserDetailsService.saveNewUser(registrationDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ModelAndView("redirect:/registration?success"));
        }
    }
}
