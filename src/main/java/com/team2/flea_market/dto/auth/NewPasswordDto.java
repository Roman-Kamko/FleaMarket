package com.team2.flea_market.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Schema(name = "NewPassword")
public record NewPasswordDto(
        @NotBlank
        @Length(min = 8, max = 16, message = "некорректная длина текущего пароля: ${validatedValue}")
        @Schema(description = "текущий пароль", minimum = "8", maximum = "16", example = "password")
        String currentPassword,
        @NotBlank
        @Length(min = 8, max = 16, message = "некорректная длина нового пароля: ${validatedValue}")
        @Schema(description = "новый пароль", minimum = "8", maximum = "16", example = "password123")
        String newPassword
) {
}
