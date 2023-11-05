package com.team2.flea_market.service.impl;

import com.team2.flea_market.dto.auth.NewPasswordDto;
import com.team2.flea_market.dto.user.UpdateUserDto;
import com.team2.flea_market.dto.user.UserDto;
import com.team2.flea_market.entity.Image;
import com.team2.flea_market.entity.User;
import com.team2.flea_market.exception.PasswordChangeException;
import com.team2.flea_market.mapper.UserMapper;
import com.team2.flea_market.repository.UserRepository;
import com.team2.flea_market.service.ImageService;
import com.team2.flea_market.service.SecurityService;
import com.team2.flea_market.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final ImageService imageService;
    private final SecurityService securityService;

    @Override
    @Transactional
    public void setPassword(NewPasswordDto newPasswordDto) {
        User user = securityService.getCurrentUser();
        String username = user.getEmail();
        if (encoder.matches(newPasswordDto.currentPassword(), user.getPassword())) {
            user.setPassword(encoder.encode(newPasswordDto.newPassword()));
            userRepository.save(user);
            log.info("пользователь \"{}\" изменил пароль", username);
        } else {
            throw new PasswordChangeException(username);
        }
    }

    @Override
    public UserDto getInfo() {
        return userMapper.toDto(securityService.getCurrentUser());
    }

    @Override
    @Transactional
    public UpdateUserDto update(UpdateUserDto updateUserDto) {
        User user = securityService.getCurrentUser();
        userMapper.toUpdatedEntity(updateUserDto, user);
        userRepository.save(user);
        log.info("пользователь \"{}\" обновил данные", user.getEmail());
        return updateUserDto;
    }

    @Override
    @Transactional
    public void updateImage(MultipartFile imageFile) {
        User currentUser = securityService.getCurrentUser();
        Image currentOrNewImage = imageService.uploadImage(imageFile, currentUser.getImage());
        currentUser.setImage(currentOrNewImage);
        log.info("пользователь \"{}\" установил новый аватар, ID аватара {}",
                currentUser.getEmail(), currentOrNewImage.getId());
    }

    @Override
    public Image getImage(Integer id) {
        return securityService.getCurrentUser().getImage();
    }

}
