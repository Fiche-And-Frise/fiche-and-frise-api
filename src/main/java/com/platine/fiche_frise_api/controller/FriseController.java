package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Evenement;
import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.service.FriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frises")
public class FriseController {
    private final FriseService friseService;

    public FriseController(FriseService friseService) {
        this.friseService = friseService;
    }

    @GetMapping("/")
    public Iterable<Frise> getAllFrises(){
        return this.friseService.getAllFrises();
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
}
