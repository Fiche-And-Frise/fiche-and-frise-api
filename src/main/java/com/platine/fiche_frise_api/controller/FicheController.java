package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.NewFicheRequest;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.config.MyUserDetails;
import com.platine.fiche_frise_api.service.FicheService;
import com.platine.fiche_frise_api.config.MyUserDetailsService;
import com.platine.fiche_frise_api.service.ThemeService;
import com.platine.fiche_frise_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fiches")
public class FicheController {

    private final FicheService ficheService;
    private final UserService userService;
    private final ThemeService themeService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    public FicheController(FicheService ficheService, UserService userService, ThemeService themeService) {
        this.ficheService = ficheService;
        this.userService = userService;
        this.themeService = themeService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Fiche>> getAllFiches(){
        User currentUser = getCurrentUser();
        if(currentUser != null){
            System.out.println("Dans le get fiches : " + currentUser);
            return ResponseEntity.status(HttpStatus.OK).body(this.ficheService.getFichesByUser(currentUser));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/{id}")
    public Fiche getFiche(@PathVariable int id){
        return this.ficheService.getFiche(id);
    }

    private User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && !(auth.getPrincipal() instanceof String)){
            System.out.println("Principal : " + auth.getPrincipal());
            MyUserDetails user = (MyUserDetails) auth.getPrincipal();
            return userService.getUserByUserName(user.getUsername());
        }
        return null;
    }

    @PostMapping("/new")
    public Fiche createFiche(@RequestBody NewFicheRequest request){
        Theme newTheme = request.getTheme();
        if(this.themeService.getTheme(newTheme.getId()) == null){
            newTheme = new Theme(request.getTheme().getName(), request.getTheme().getColor(), getCurrentUser());
            this.themeService.createTheme(newTheme);
        }
        Fiche newFiche = request.getFiche();
        newFiche.setTheme(newTheme);
        newFiche.setUser(getCurrentUser());
        return this.ficheService.createFiche(newFiche);
    }

    @PostMapping("/delete/{id}")
    public String deleteFiche(@PathVariable int id){
        this.ficheService.deleteFiche(id);
        return "deleted";
    }

    @PutMapping("/update")
    public Fiche updateFiche(@RequestBody NewFicheRequest request){
        Fiche newFiche = request.getFiche();
        newFiche.setTheme(request.getTheme());
        newFiche.setUser(getCurrentUser());
        return this.ficheService.updateFiche(newFiche);
    }
}
