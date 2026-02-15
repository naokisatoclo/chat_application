package com.example.chat_application.controller.security;

import com.example.chat_application.repository.UserRepository;
import com.example.chat_application.repository.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmail(email);
        return user
                .map(LoginUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("not found email : " + email));
    }

}