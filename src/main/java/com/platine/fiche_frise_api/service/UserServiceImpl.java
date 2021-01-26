package com.platine.fiche_frise_api.service;

import com.platine.fiche_frise_api.bo.Fiche;
import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    public User getUserByUserName(String username) {
        return repository.findByUserName(username).orElse(null);
    }
}
