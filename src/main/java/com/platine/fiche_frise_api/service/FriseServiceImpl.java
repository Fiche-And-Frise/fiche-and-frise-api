package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Evenement;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.repository.FriseRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FriseServiceImpl implements FriseService{

   private FriseRepository repository;

   public FriseServiceImpl(FriseRepository repository){
       this.repository = repository;
   }

    @Override
    public Frise getFrise(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Frise> getAllFrises() {
        return this.repository.findAll();
    }

    @Override
    public Frise createFrise(Frise frise) {
        return this.repository.save(frise);
    }

    @Override
    public Frise updateFrise(Frise frise) {
        return this.repository.save(frise);
    }

    @Override
    public void deleteFrise(int id) {
        this.repository.delete(this.repository.findById(id).get());
    }

    @Override
    public Iterable<Evenement> getAllEvenements(int id) {
        return Objects.requireNonNull(this.repository.findById(id).orElse(null)).getEvenements();
    }
}
