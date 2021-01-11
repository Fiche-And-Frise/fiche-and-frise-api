package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.repository.FicheRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FicheServiceImplTest {

    @Test
    void getAllFiches_shouldCallTheRepository() {
        var ficheRepo = mock(FicheRepository.class);
        var ficheService = new FicheServiceImpl(ficheRepo);

        ficheService.getAllFiches();

        verify(ficheRepo).findAll();
    }

    @Test
    void getFiche_shouldCallTheRepository() {
        var ficheRepo = mock(FicheRepository.class);
        var ficheService = new FicheServiceImpl(ficheRepo);

        ficheService.getFiche(1);

        verify(ficheRepo).findById(1);
    }

    @Test
    void createFiche_shouldCallTheRepository() {
        var ficheRepo = mock(FicheRepository.class);
        var ficheService = new FicheServiceImpl(ficheRepo);

        var fiche1 = new Fiche();
        ficheService.createFiche(fiche1);

        verify(ficheRepo).save(fiche1);
    }
}
