package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Fiche;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class FicheRepositoryTest {
    @Autowired
    FicheRepository repository;

    @Test
    void ficheRepository_shouldExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(FicheRepository.class));
    }

    @Test
    void testSave(){
        var fiche = new Fiche(1, "Première fiche",
                "Je suis écrit sur le recto",
                "Je suis écrit sur le verso",
                "Le thème");

        repository.save(fiche);

        var saved = repository.findById(fiche.getId()).orElse(null);

        assertEquals(1, saved.getId());
    }

}
