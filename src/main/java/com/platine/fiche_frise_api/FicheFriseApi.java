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
    public CommandLineRunner demo(FicheRepository ficheRepository, FriseRepository friseRepository, ThemeRepository themeRepository, EvenementRepository evenementRepository, UserRepository userRepository) {
        return (args) -> {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User maxime = new User("maxime", passwordEncoder.encode("lol"),
                    true, "ROLE_USER");

            User yanis = new User("yanis", passwordEncoder.encode("bonjour"),
                    true, "ROLE_USER");

            var themePremiereGM = new Theme("TestTheme",
                    0,
                    maxime);

            var themeSecondeGM = new Theme("TestTheme",
                    0,
                    yanis);

            var ficheMaxime = new Fiche( "Première fiche de Maxime",
                    "La première fiche de Maxime",
                    "19/07/1998",
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

            var friseMaxime = new Frise("Frise de Maxime",
                    1998,
                    2050,
                    maxime,
                    themePremiereGM);

            var friseYanis = new Frise("Frise de Yanis",
                    1900,
                    2000,
                    yanis,
                    themeSecondeGM);

            var evenementPremiereGM = new Evenement(
                    "Premiere Guerre Mondiale",
                    1914,
                    friseMaxime);
            var evenementDeuxiemeGM = new Evenement(
                    "Deuxieme Guerre Mondiale",
                    1939,
                    friseYanis);

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
            evenementRepository.save(evenementPremiereGM);
            evenementRepository.save(evenementDeuxiemeGM);

        };
    }

}
