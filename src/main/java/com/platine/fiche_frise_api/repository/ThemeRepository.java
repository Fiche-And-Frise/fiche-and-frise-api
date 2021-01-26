package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.Theme;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {
    @Query(value = "SELECT t from Theme t where t.user=:user")
    Iterable<Theme> findAllByUser(User user);
}
