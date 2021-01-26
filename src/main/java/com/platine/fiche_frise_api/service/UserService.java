package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByUserName(String username);

}
