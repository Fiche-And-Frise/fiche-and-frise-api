package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;

import java.util.List;

public interface FicheService {
    Fiche getFiche(int id);
    Fiche getFiche(String theme);
    List<Fiche> getAllFiches();
    List<Fiche> getFichesByTheme(String theme);
}
