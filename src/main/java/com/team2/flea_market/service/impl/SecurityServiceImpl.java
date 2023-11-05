package com.team2.flea_market.service.impl;

import com.team2.flea_market.entity.User;
import com.team2.flea_market.exception.UserNotFoundException;
import com.team2.flea_market.repository.UserRepository;
import com.team2.flea_market.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(currentUsername)
                .orElseThrow(() -> new UserNotFoundException(currentUsername));
    }

}
