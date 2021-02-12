package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.*;
import com.platine.fiche_frise_api.config.MyUserDetails;
import com.platine.fiche_frise_api.service.FriseService;
import com.platine.fiche_frise_api.service.ThemeService;
import com.platine.fiche_frise_api.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/frises")
public class FriseController {
    private final FriseService friseService;
    private final UserService userService;
    private final ThemeService themeService;

    public FriseController(FriseService friseService, UserService userService, ThemeService themeService) {
        this.friseService = friseService;
        this.userService = userService;
        this.themeService = themeService;
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

    @PostMapping("/new")
    public Frise createFrise(@RequestBody NewFriseRequest request){
        Theme newTheme = request.getTheme();
        if(this.themeService.getTheme(newTheme.getId()) == null){
            newTheme = new Theme(request.getTheme().getName(), request.getTheme().getColor(), getCurrentUser());
            this.themeService.createTheme(newTheme);
        }
        Frise newFrise = request.getFrise();
        newFrise.setTheme(newTheme);
        newFrise.setUser(getCurrentUser());
        newFrise.setEvenements(Collections.emptyList());
        return this.friseService.createFrise(newFrise);
    }

    @PutMapping("/update/evenement")
    public Frise updateEvenement(@RequestBody NewEvenementRequest request){
        Frise newFrise = request.getFrise();
        Theme t = this.themeService.getTheme(request.getTheme());
        newFrise.setTheme(t);
        newFrise.setUser(getCurrentUser());
        Evenement newEvenement = request.getEvenement();
        List<Evenement> events = newFrise.getEvenements();
        events.add(request.getIndex(), newEvenement);
        newFrise.setEvenements(events);
        //this.friseService.createEvenement(newEvenement);
        return this.friseService.updateFrise(newFrise);
    }

    @PostMapping("/delete/evenement")
    public Frise deleteEvenement(@RequestBody NewFriseRequest request){
        Frise newFrise = request.getFrise();
        Theme t = request.getTheme();
        newFrise.setTheme(t);
        newFrise.setUser(getCurrentUser());
        return this.friseService.updateFrise(newFrise);
    }

    @PostMapping("/delete/{id}")
    public String deleteFrise(@PathVariable int id){
        this.friseService.deleteFrise(id);
        return "deleted";
    }

    private User getCurrentUser(){
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserByUserName(user.getUsername());
    }
}
