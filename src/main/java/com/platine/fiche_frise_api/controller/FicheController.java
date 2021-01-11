package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.service.FicheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fiches")
public class FicheController {

    private final FicheService ficheService;

    public FicheController(FicheService ficheService) {
        this.ficheService = ficheService;
    }

    @GetMapping("/")
    public Iterable<Fiche> getAllFiches(){
        return this.ficheService.getAllFiches();
    }

    @GetMapping("/{id}")
    public Fiche getFiche(@PathVariable int id){
        return this.ficheService.getFiche(id);
    }
}
