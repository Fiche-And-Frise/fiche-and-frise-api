package com.platine.fiche_frise_api.bo;

import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.Id;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FicheTest {

    @Test
    void fiche_shouldBeAnEntity(){
        assertNotNull(Fiche.class.getAnnotation(Entity.class));
    }

    @Test
    void ficheId_shouldBeAnId() throws NoSuchFieldException{
        assertNotNull(Fiche.class.getDeclaredField("id").getAnnotation(Id.class));
    }


}
