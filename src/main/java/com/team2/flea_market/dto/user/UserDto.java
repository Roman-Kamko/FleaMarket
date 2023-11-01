package com.team2.flea_market.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "User")
public record UserDto(
        @Schema(description = "id пользователя")
        Integer id,
        @Schema(description = "логин пользователя")
        String email,
        @Schema(description = "имя пользователя")
        String firstName,
        @Schema(description = "фамилия пользователя")
        String lastName,
        @Schema(description = "телефон пользователя")
        String phone,
        @Schema(description = "роль пользователя")
        Role role,
        @Schema(description = "ссылка на аватар пользователя")
        String image
) {
}
