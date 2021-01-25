package com.platine.fiche_frise_api.config;

import com.platine.fiche_frise_api.bo.User;
import com.platine.fiche_frise_api.bo.UserRegistrationDto;
import com.platine.fiche_frise_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));

        return user.map(MyUserDetails::new).get();
    }

    public User saveNewUser(UserRegistrationDto userRegistrationDto){
        User user = new User(userRegistrationDto.getUserName(),
                userRegistrationDto.getPassword(),
                true, "ROLE_USER");

        return userRepository.save(user);
    }
}
