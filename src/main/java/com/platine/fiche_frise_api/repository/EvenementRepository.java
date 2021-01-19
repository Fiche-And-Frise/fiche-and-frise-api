package com.platine.fiche_frise_api.repository;

import com.platine.fiche_frise_api.bo.Evenement;
import org.springframework.data.repository.CrudRepository;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {
}
