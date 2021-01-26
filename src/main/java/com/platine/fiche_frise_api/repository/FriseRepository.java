package com.platine.fiche_frise_api.repository;


import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Frise;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriseRepository extends CrudRepository<Frise, Integer> {

    @Query(value = "SELECT f from Frise f where f.user=:user")
    Iterable<Frise> findAllByUser(User user);
}
