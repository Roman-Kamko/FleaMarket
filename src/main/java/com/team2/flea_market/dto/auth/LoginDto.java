package com.team2.flea_market.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Schema(name = "Login")
public record LoginDto(
        @NotBlank
        @Length(min = 4, max = 32, message = "некорректная длина логина: ${validatedValue}")
        @Schema(description = "логин", minimum = "4", maximum = "32", example = "user@gmail.com")
        String username,
        @NotBlank
        @Length(min = 8, max = 16, message = "некорректная длина пароля: ${validatedValue}")
        @Schema(description = "текущий пароль", minimum = "8", maximum = "16", example = "password")
        String password
) {
}
