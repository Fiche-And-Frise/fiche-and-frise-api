package com.platine.fiche_frise_api.service;


import com.platine.fiche_frise_api.bo.Frise;
import org.springframework.stereotype.Service;

@Service
public interface FriseService {
    Frise getFrise(int id);
    Iterable<Frise> getAllFrises();

    Frise createFrise(Frise frise);
    Frise updateFrise(Frise frise);
    void deleteFrise(int id);
}
