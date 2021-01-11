package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.bo.Fiche;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FicheControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private FicheController controller;

    @Test
    void ficheController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getFiche_withIdOne_shouldReturnFiche1() {
        var fiche1 = this.restTemplate.getForObject("http://localhost:" + port + "/fiches/1", Fiche.class);
        assertNotNull(fiche1);
        assertEquals(1, fiche1.getId());
        assertEquals("Première fiche de Maxime", fiche1.getName());
        assertEquals("La première fiche de Maxime", fiche1.getRecto());
        assertEquals("19/07/1998", fiche1.getVerso());

    }

    @Test
    void getAllFiches_shouldReturnFiche1AndFiche2() {
        var fiches = this.restTemplate.getForObject("http://localhost:" + port + "/fiches/", Fiche[].class);
        assertNotNull(fiches);
        assertEquals(2, fiches.length);

        assertEquals(1, fiches[0].getId());
        assertEquals(2, fiches[1].getId());
    }
}
