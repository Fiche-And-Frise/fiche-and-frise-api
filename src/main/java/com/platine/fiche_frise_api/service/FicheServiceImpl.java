package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.repository.FicheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Iterable<Fiche> getFichesByTheme(int themeId) {
        return null;
    }

    @Override
    public Iterable<Fiche> getFichesByUser(User user) {
        return this.repository.findAllByUser(user);
    }

    @Override
    public Iterable<Fiche> getAllFiches() {
        return this.repository.findAll();
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
