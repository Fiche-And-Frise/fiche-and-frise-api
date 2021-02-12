package com.platine.fiche_frise_api;

import com.platine.fiche_frise_api.bo.*;
import com.platine.fiche_frise_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FicheFriseApi {

    public static void main(String... args) {
        SpringApplication.run(FicheFriseApi.class);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(FicheRepository ficheRepository, FriseRepository friseRepository, ThemeRepository themeRepository, UserRepository userRepository) {
        return (args) -> {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User maxime = new User("maxime", passwordEncoder.encode("lol"),
                    true, "ROLE_USER");

            User yanis = new User("yanis", passwordEncoder.encode("bonjour"),
                    true, "ROLE_USER");

            var themePremiereGM = new Theme("Première Guerre mondiale",
                    -2452466,
                    maxime);

            var themeSecondeGM = new Theme("Seconde Guerre mondiale",
                    -14834678,
                    maxime);

            var themeRoisDeFrance = new Theme("Rois de France",
                    -15502913,
                    maxime);

            var ficheMaxime = new Fiche( "Début de la guerre",
                    "Le prince héritier de l'empire austro-hongrois est victime d'un attentat à Sarajevo " +
                            "perpétré par un étudiant nationaliste serbe. L'Autriche-Hongrie déclare la guerre à la Serbie " +
                            "le 28 juillet. Le jeu des alliances conduira à un embrasement progressif en Europe. ",
                    "28 juin 1914",
                    maxime,
                    themePremiereGM);

            var ficheMaxime2 = new Fiche( "Fin de la guerre",
                    "L’armistice met provisoirement fin aux " +
                            "combats de la Première Guerre mondiale, reconnaissant de facto la victoire des " +
                            "Alliés et la défaite de l'Allemagne",
                    "11 novembre 1918",
                    maxime,
                    themePremiereGM);

            var ficheMaxime3 = new Fiche("Début de la guerre",
                    "Provoquée par le règlement insatisfaisant de la Première Guerre mondiale et par les ambitions " +
                            "expansionnistes et hégémoniques des trois principales nations de l’Axe (le Troisième " +
                            "Reich, l'Italie fasciste et l'Empire du Japon), elle est favorisée par la convergence " +
                            "d’un ensemble de tensions et conflits régionaux",
                    "1er septembre 1939",
                    maxime,
                    themeSecondeGM);

            var ficheMaxime4 = new Fiche("Fin de la guerre",
                    "C'est la fin de la guerre",
                    "8 mai 1945",
                    maxime,
                    themeSecondeGM);

            var friseMaxime = new Frise("Première Guerre mondiale",
                    1914,
                    1918,
                    maxime,
                    themePremiereGM);

            var friseMaxime2 = new Frise("Deuxième Guerre mondiale",
                    1939,
                    1945,
                    maxime,
                    themeSecondeGM);

            var evenementPremiereGM = new Evenement(
                    "Début de la guerre",
                    "28 juillet 1914",6,3);
            var evenementPremiereGMfin = new Evenement(
                    "Fin de la guerre",
                    "11 novembre 1918");
            var evenementDeuxiemeGM = new Evenement(
                    "Début de la guerre",
                    "1939",8,4);
            var evenementDeuxiemeGMfin = new Evenement(
                    "Fin de la guerre",
                    "8 mai 1945");

            friseMaxime.setEvenements(Arrays.asList(evenementPremiereGM, evenementPremiereGMfin));
            friseMaxime2.setEvenements(Arrays.asList(evenementDeuxiemeGM, evenementDeuxiemeGMfin));


            //save a user
            userRepository.save(maxime);
            userRepository.save(yanis);

            //save a theme
            themeRepository.save(themePremiereGM);
            themeRepository.save(themeSecondeGM);
            themeRepository.save(themeRoisDeFrance);

            // save a couple of fiches
            ficheRepository.save(ficheMaxime);
            ficheRepository.save(ficheMaxime2);
            ficheRepository.save(ficheMaxime3);
            ficheRepository.save(ficheMaxime4);

            //save a frise
            friseRepository.save(friseMaxime);
            friseRepository.save(friseMaxime2);

            //save an event
            //evenementRepository.save(evenementPremiereGM);
            //evenementRepository.save(evenementPremiereGMfin);
            //evenementRepository.save(evenementDeuxiemeGM);

        };
    }

}
