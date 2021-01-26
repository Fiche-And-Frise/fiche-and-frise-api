package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Evenement;
import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.config.MyUserDetails;
import com.platine.fiche_frise_api.service.FriseService;
import com.platine.fiche_frise_api.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frises")
public class FriseController {
    private final FriseService friseService;
    private final UserService userService;

    public FriseController(FriseService friseService, UserService userService) {
        this.friseService = friseService;
        this.userService = userService;
    }

    @GetMapping("")
    public Iterable<Frise> getAllFrises(){
        User currentUser = getCurrentUser();
        if(currentUser != null){
            System.out.println("Dans le get fiches : " + currentUser);
            return this.friseService.getFrisesByUser(currentUser);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Frise getFrise(@PathVariable int id){
        return this.friseService.getFrise(id);
    }

    @GetMapping("/{id}/evenements/")
    public Iterable<Evenement> getAllEvenements(@PathVariable int id){
        return this.friseService.getAllEvenements(id);
    }

    @GetMapping("/{id}/evenements/{idEvenement}")
    public Evenement getEvenement(@PathVariable int id, @PathVariable int idEvenement){
        return this.friseService.getEvenement(id, idEvenement);
    }

    private User getCurrentUser(){
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserByUserName(user.getUsername());
    }
}
