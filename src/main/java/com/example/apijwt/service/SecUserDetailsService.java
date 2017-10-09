package com.example.apijwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.apijwt.model.User;
import com.example.apijwt.repository.UserRepository;

@Component
public class SecUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        /*Here add user data layer fetching from the MongoDB.
          I have used userRepository*/
        User user = userRepository.findByNickname(nickname);
        if(user == null){
            throw new UsernameNotFoundException(nickname);
        }else{
            UserDetails details = new SecUserDetails(user);
            return details;
        }
    }
}