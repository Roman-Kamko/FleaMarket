package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.auth.RegisterDto;
import com.team2.flea_market.dto.user.Role;
import com.team2.flea_market.dto.user.UserDto;
import com.team2.flea_market.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl();

    private final User newUser = prepareNewUser();
    private final RegisterDto registerDto = prepareRegisterDto();
    private final UserDto userDto = prepareUserDto();


    @Test
    void toEntityTest() {
        assertThat(userMapper.toEntity(registerDto)).isEqualTo(newUser);
    }

    @Test
    void toDto() {
        assertThat(userMapper.toDto(newUser)).isEqualTo(userDto);
    }

    private User prepareNewUser() {
        return User.builder()
                .id(null)
                .email("qwe@gmail.com")
                .password("12344321")
                .firstName("ewq")
                .lastName("qwe")
                .phone("+79379998877")
                .role(Role.USER)
                .image(null)
                .ads(null)
                .comments(null)
                .build();
    }

    private RegisterDto prepareRegisterDto() {
        return RegisterDto.builder()
                .username("qwe@gmail.com")
                .password("12344321")
                .firstName("ewq")
                .lastName("qwe")
                .phone("+79379998877")
                .role(Role.USER)
                .build();
    }

    private UserDto prepareUserDto() {
        return UserDto.builder()
                .id(null)
                .email("qwe@gmail.com")
                .firstName("ewq")
                .lastName("qwe")
                .phone("+79379998877")
                .role(Role.USER)
                .image(null)
                .build();
    }

}