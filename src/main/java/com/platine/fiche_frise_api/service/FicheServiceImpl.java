package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.repository.FicheRepository;

import java.util.List;

public class FicheServiceImpl implements FicheService{

    private FicheRepository repository;

    public FicheServiceImpl(FicheRepository ficheRepository){
        this.repository = ficheRepository;
    }

    @Override
    public Fiche getFiche(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Fiche getFiche(String theme) {
        return null;
    }

    @Override
    public Iterable<Fiche> getAllFiches() {
        return this.repository.findAll();
    }

    @Override
    public List<Fiche> getFichesByTheme(String theme) {
        return null;
    }

    @Override
    public Fiche createFiche(Fiche fiche) {
        return this.repository.save(fiche);
    }

    @Override
    public Fiche updateFiche(Fiche fiche) {
        return this.repository.save(fiche);
    }

    @Override
    public void deleteFiche(int id) {
        this.repository.delete(this.repository.findById(id).get());
    }
}
