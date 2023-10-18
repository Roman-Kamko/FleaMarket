package com.team2.flea_market.service.impl;

import com.team2.flea_market.dto.auth.RegisterDto;
import com.team2.flea_market.service.AuthService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;

    public AuthServiceImpl(UserDetailsManager manager,
                           PasswordEncoder passwordEncoder) {
        this.manager = manager;
        this.encoder = passwordEncoder;
    }

    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterDto register) {
        if (manager.userExists(register.username())) {
            return false;
        }
        manager.createUser(
                User.builder()
                        .passwordEncoder(this.encoder::encode)
                        .password(register.password())
                        .username(register.username())
                        .roles(register.role().name())
                        .build());
        return true;
    }

}
