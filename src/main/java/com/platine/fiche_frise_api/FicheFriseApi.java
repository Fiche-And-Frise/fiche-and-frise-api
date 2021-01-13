package com.platine.fiche_frise_api;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.repository.FicheRepository;
import com.platine.fiche_frise_api.repository.FriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FicheFriseApi {

    public static void main(String... args) {
        SpringApplication.run(FicheFriseApi.class);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(FicheRepository ficherepository, FriseRepository friserepository) {
        return (args) -> {
            var ficheMaxime = new Fiche(1, "Première fiche de Maxime",
                    "La première fiche de Maxime",
                    "19/07/1998",
                    "Le thème");

            var ficheYanis = new Fiche(2, "Première fiche de Yanis",
                    "La première fiche de Yanis, ici c'est le verso",
                    "Date inconnue",
                    "L'autre thème");

            var friseTest = new Frise(1,"Frise de test",
                    "Sans Thème",
                    1900,
                    2000,
                    "Pas d'evenements");

            // save a couple of fiches
            ficherepository.save(ficheMaxime);
            ficherepository.save(ficheYanis);

            //save a frise
            friserepository.save(friseTest);
        };
    }

}
