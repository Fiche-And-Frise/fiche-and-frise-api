package com.platine.fiche_frise_api.controller;

import com.platine.fiche_frise_api.service.FicheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class FicheControllerTest {

    @Mock
    private FicheService ficheService;

    @InjectMocks
    private FicheController ficheController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllFiches_shouldCallTheService() {
        ficheController.getAllFiches();

        verify(ficheService).getAllFiches();
    }

    @Test
    void getFiche_shouldCallTheService() {
        ficheController.getFiche(1);

        verify(ficheService).getFiche(1);
    }

    @Test
    void ficheController_shouldBeAnnotated(){
        var controllerAnnotation =
                FicheController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        var requestMappingAnnotation =
                FicheController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/fiches"}, requestMappingAnnotation.value());
    }

    @Test
    void getAllFiches_shouldBeAnnotated() throws NoSuchMethodException {
        var getAllFiches =
                FicheController.class.getDeclaredMethod("getAllFiches");
        var getMapping = getAllFiches.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }

    @Test
    void getFiche_shouldBeAnnotated() throws NoSuchMethodException {
        var getFiche =
                FicheController.class.getDeclaredMethod("getFiche", int.class);
        var getMapping = getFiche.getAnnotation(GetMapping.class);

        var pathVariableAnnotation = getFiche.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{id}"}, getMapping.value());

        assertNotNull(pathVariableAnnotation);
    }
}
