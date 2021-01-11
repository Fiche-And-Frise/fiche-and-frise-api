package com.platine.fiche_frise_api;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.repository.FicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FicheApi {

    public static void main(String... args) {
        SpringApplication.run(FicheApi.class);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(FicheRepository repository) {
        return (args) -> {
            var ficheMaxime = new Fiche(1, "Première fiche de Maxime",
                    "La première fiche de Maxime",
                    "19/07/1998",
                    "Le thème");

            var ficheYanis = new Fiche(2, "Première fiche de Yanis",
                    "La première fiche de Yanis, ici c'est le verso",
                    "Date inconnue",
                    "L'autre thème");

            // save a couple of fiches
            repository.save(ficheMaxime);
            repository.save(ficheYanis);
        };
    }

}
