package com.team2.flea_market.service;

import com.team2.flea_market.dto.auth.RegisterDto;

public interface AuthService {

        boolean login(String userName, String password);

        boolean register(RegisterDto register);

}
