package com.team2.flea_market.service.impl;

import com.team2.flea_market.dto.auth.RegisterDto;
import com.team2.flea_market.entity.User;
import com.team2.flea_market.exception.UserAlreadyRegisterException;
import com.team2.flea_market.exception.UserNotFoundException;
import com.team2.flea_market.mapper.UserMapper;
import com.team2.flea_market.repository.UserRepository;
import com.team2.flea_market.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public boolean login(String userName, String password) {
        if (!userRepository.existsByEmail(userName)) {
            throw new UserNotFoundException(userName);
        }
        User user = userRepository.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException(""));
        return encoder.matches(password, user.getPassword());
    }

    @Override
    public boolean register(RegisterDto register) {
        String username = register.username();
        if (userRepository.existsByEmail(username)) {
            throw new UserAlreadyRegisterException(username);
        }
        User user = userMapper.toEntity(register);
        user.setPassword(encoder.encode(register.password()));
        userRepository.save(user);
        return true;
    }

}
