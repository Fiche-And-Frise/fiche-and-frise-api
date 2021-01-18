package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {

}
