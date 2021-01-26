package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String name);


    //Iterable<Fiche> findAllFiches(int id);

}
