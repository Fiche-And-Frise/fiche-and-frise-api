package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.config.MyUserDetails;
import com.platine.fiche_frise_api.service.ThemeService;
import com.platine.fiche_frise_api.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private ThemeService themeService;
    private final UserService userService;

    public ThemeController(ThemeService themeService, UserService userService){
        this.themeService = themeService;
        this.userService = userService;
    }

    @GetMapping("")
    public Iterable<Theme> getAllThemes(){
        User currentUser = getCurrentUser();
        if(currentUser != null){
            System.out.println("Dans le get fiches : " + currentUser);
            return this.themeService.getThemesByUser(currentUser);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Theme getTheme(@PathVariable int id){
        return this.themeService.getTheme(id);
    }

    private User getCurrentUser(){
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserByUserName(user.getUsername());
    }
}
