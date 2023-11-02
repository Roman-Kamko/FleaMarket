package com.team2.flea_market.service;

import com.team2.flea_market.dto.auth.NewPasswordDto;
import com.team2.flea_market.dto.user.UpdateUserDto;
import com.team2.flea_market.dto.user.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    void setPassword(NewPasswordDto newPasswordDto);

    UserDto getInfo();

    UpdateUserDto update(UpdateUserDto updateUserDto);

    void updateImage(MultipartFile image);

}
