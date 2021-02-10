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
                    0,
                    maxime);

            var themeSecondeGM = new Theme("TestTheme",
                    0,
                    yanis);

            var ficheMaxime = new Fiche( "Début Première Guerre mondiale",
                    "Le prince héritier de l'empire austro-hongrois est victime d'un attentat à Sarajevo " +
                            "perpétré par un étudiant nationaliste serbe. L'Autriche-Hongrie déclare la guerre à la Serbie " +
                            "le 28 juillet. Le jeu des alliances conduira à un embrasement progressif en Europe. ",
                    "28 juin 1914",
                    maxime,
                    themePremiereGM);

            var ficheMaxime2 = new Fiche("Deuxième fiche de Maxime",
                    "La deuxième fiche de Maxime",
                    "Je suis le verso !",
                    maxime,
                    themePremiereGM);

            var ficheYanis = new Fiche("Première fiche de Yanis",
                    "La première fiche de Yanis, ici c'est le verso",
                    "Date inconnue",
                    yanis,
                    themeSecondeGM);

            var friseMaxime = new Frise("Frise Première Guerre mondiale",
                    1914,
                    1918,
                    maxime,
                    themePremiereGM);

            var friseYanis = new Frise("Frise de Yanis",
                    1900,
                    2000,
                    yanis,
                    themeSecondeGM);

            var evenementPremiereGM = new Evenement(
                    "Début Premiere Guerre Mondiale",
                    "28 juillet 1914");
            var evenementPremiereGMfin = new Evenement(
                    "Fin Premiere Guerre Mondiale",
                    "11 novembre 1918");
            var evenementDeuxiemeGM = new Evenement(
                    "Deuxieme Guerre Mondiale",
                    "1939");

            friseMaxime.setEvenements(Arrays.asList(evenementPremiereGM, evenementPremiereGMfin));


            //save a user
            userRepository.save(maxime);
            userRepository.save(yanis);

            //save a theme
            themeRepository.save(themePremiereGM);
            themeRepository.save(themeSecondeGM);

            // save a couple of fiches
            ficheRepository.save(ficheMaxime);
            ficheRepository.save(ficheMaxime2);
            ficheRepository.save(ficheYanis);

            //save a frise
            friseRepository.save(friseMaxime);
            friseRepository.save(friseYanis);

            //save an event
            //evenementRepository.save(evenementPremiereGM);
            //evenementRepository.save(evenementPremiereGMfin);
            //evenementRepository.save(evenementDeuxiemeGM);

        };
    }

}
