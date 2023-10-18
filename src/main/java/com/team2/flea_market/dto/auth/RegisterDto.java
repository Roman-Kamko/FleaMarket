package com.team2.flea_market.dto.auth;

import com.sun.istack.NotNull;
import com.team2.flea_market.dto.user.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Schema(name = "Register")
public record RegisterDto(
        @Schema(description = "логин")
        @NotBlank
        @Min(4)
        @Max(32)
        String username,
        @Schema(description = "пароль")
        @NotBlank
        @Min(8)
        @Max(16)
        String password,
        @Schema(description = "имя пользователя")
        @NotBlank
        @Min(2)
        @Max(16)
        String firstName,
        @Schema(description = "фамилия пользователя")
        @Min(2)
        @Max(16)
        String lastName,
        @Schema(description = "телефон пользователя")
        @NotBlank
        @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
        String phone,
        @NotNull
        Role role
) {
}
