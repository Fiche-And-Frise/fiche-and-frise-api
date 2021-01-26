package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheRepository extends CrudRepository<Fiche, Integer> {

    @Query(value = "SELECT f from Fiche f where f.user=:user")
    Iterable<Fiche> findAllByUser(User user);
}
