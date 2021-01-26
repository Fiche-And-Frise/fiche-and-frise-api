package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.service.ThemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private ThemeService themeService;

    public ThemeController(ThemeService themeService){
        this.themeService = themeService;
    }

    @GetMapping("")
    public Iterable<Theme> getAllThemes(){
        return this.themeService.getAllThemes();
    }

    @GetMapping("/{id}")
    public Theme getTheme(@PathVariable int id){
        return this.themeService.getTheme(id);
    }

}
