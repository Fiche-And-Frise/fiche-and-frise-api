package com.platine.fiche_frise_api;

import com.platine.fiche_frise_api.bo.Evenement;
import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FicheFriseApi {

    public static void main(String... args) {
        SpringApplication.run(FicheFriseApi.class);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(FicheRepository ficheRepository, FriseRepository friseRepository, ThemeRepository themeRepository, EvenementRepository evenementRepository) {
        return (args) -> {

            List<Fiche> listFiches = new ArrayList<>();
            List<Frise> listFrises = new ArrayList<>();

            List<Evenement> listEvenements = new ArrayList<>();

            var evenementPremiereGM = new Evenement(10,
                    "Premiere Guerre Mondiale",
                    1914,
                    1918);
            var evenementDeuxiemeGM = new Evenement(11,
                    "Deuxieme Guerre Mondiale",
                    1939,
                    1945);

            listEvenements.add(evenementPremiereGM);
            listEvenements.add(evenementDeuxiemeGM);


            var ficheMaxime = new Fiche(1, "Première fiche de Maxime",
                    "La première fiche de Maxime",
                    "19/07/1998");

            var ficheYanis = new Fiche(2, "Première fiche de Yanis",
                    "La première fiche de Yanis, ici c'est le verso",
                    "Date inconnue");

            var friseTest = new Frise(1,"Frise de test",
                    1900,
                    2000,
                    listEvenements
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

            //save an event
            evenementRepository.save(evenementPremiereGM);
            evenementRepository.save(evenementDeuxiemeGM);

            //save a frise
            friseRepository.save(friseTest);

            //save a theme
            themeRepository.save(themeTest);

        };
    }

}
