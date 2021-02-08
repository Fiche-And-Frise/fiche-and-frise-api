package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Evenement;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.repository.EvenementRepository;
import com.platine.fiche_frise_api.repository.FriseRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FriseServiceImpl implements FriseService{

   private FriseRepository repository;
   private EvenementRepository evenementRepository;

   public FriseServiceImpl(FriseRepository repository, EvenementRepository evenementRepository){
       this.repository = repository;
       this.evenementRepository = evenementRepository;
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
    public Iterable<Frise> getFrisesByUser(User currentUser) {
        return this.repository.findAllByUser(currentUser);
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
    public Evenement createEvenement(Evenement evenement) {
        return this.evenementRepository.save(evenement);
    }

    @Override
    public Iterable<Evenement> getAllEvenements(int id) {
        return Objects.requireNonNull(this.repository.findById(id).orElse(null)).getEvenements();
    }

    @Override
    public Evenement getEvenement(int id, int idEvenement) {
        return this.repository.findById(id).orElse(null).getEvenementById(idEvenement);
    }
}
