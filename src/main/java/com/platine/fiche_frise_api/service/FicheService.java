package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FicheService {
    Fiche getFiche(int id);
    Iterable<Fiche> getAllFiches();
    Iterable<Fiche> getFichesByTheme(int themeId);
    Iterable<Fiche> getFichesByUser(User user);

    Fiche createFiche(Fiche fiche);
    Fiche updateFiche(Fiche fiche);
    void deleteFiche(int id);
}
