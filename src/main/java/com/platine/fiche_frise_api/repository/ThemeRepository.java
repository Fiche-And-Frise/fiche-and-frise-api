package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Frise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Frise, Integer> {
    
}
