package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;

import java.util.List;

public interface FicheService {
    Fiche getFiche(int id);
    Fiche getFiche(String theme);
    Iterable<Fiche> getAllFiches();
    List<Fiche> getFichesByTheme(String theme);

    Fiche createFiche(Fiche fiche);
    Fiche updateFiche(Fiche fiche);
    void deleteFiche(int id);
}
