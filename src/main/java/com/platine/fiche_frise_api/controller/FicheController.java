package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.config.MyUserDetails;
import com.platine.fiche_frise_api.service.FicheService;
import com.platine.fiche_frise_api.config.MyUserDetailsService;
import com.platine.fiche_frise_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fiches")
public class FicheController {

    private final FicheService ficheService;
    private final UserService userService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    public FicheController(FicheService ficheService, UserService userService) {
        this.ficheService = ficheService;
        this.userService = userService;
    }

    @GetMapping("")
    public Iterable<Fiche> getAllFiches(){
        User currentUser = getCurrentUser();
        if(currentUser != null){
            System.out.println("Dans le get fiches : " + currentUser);
            return this.ficheService.getFichesByUser(currentUser);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Fiche getFiche(@PathVariable int id){
        return this.ficheService.getFiche(id);
    }

    private User getCurrentUser(){
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserByUserName(user.getUsername());
    }
}
