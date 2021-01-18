package com.platine.fiche_frise_api;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.repository.FicheRepository;
import com.platine.fiche_frise_api.repository.FriseRepository;
import com.platine.fiche_frise_api.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FicheFriseApi {

    public static void main(String... args) {
        SpringApplication.run(FicheFriseApi.class);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(FicheRepository ficheRepository, FriseRepository friseRepository, ThemeRepository themeRepository) {
        return (args) -> {

            List<Fiche> listFiches = new ArrayList<>();
            List<Frise> listFrises = new ArrayList<>();


            var ficheMaxime = new Fiche(1, "Première fiche de Maxime",
                    "La première fiche de Maxime",
                    "19/07/1998");

            var ficheYanis = new Fiche(2, "Première fiche de Yanis",
                    "La première fiche de Yanis, ici c'est le verso",
                    "Date inconnue");

            var friseTest = new Frise(1,"Frise de test",
                    1900,
                    2000,
                    "Pas d'evenements"
                    );

            listFiches.add(ficheMaxime);
            listFiches.add(ficheYanis);

            listFrises.add(friseTest);

            var themeTest = new Theme(1,
                    "TestTheme",
                    "black",
                    listFiches,
                    listFrises);


            // save a couple of fiches
            ficheRepository.save(ficheMaxime);
            ficheRepository.save(ficheYanis);

            //save a frise
            friseRepository.save(friseTest);

            //save a theme
            themeRepository.save(themeTest);

        };
    }

}
