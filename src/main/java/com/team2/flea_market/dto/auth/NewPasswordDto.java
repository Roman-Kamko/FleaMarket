package com.team2.flea_market.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Schema(name = "NewPassword")
public record NewPasswordDto(
        @Schema(description = "текущий пароль")
        @NotBlank
        @Min(8)
        @Max(16)
        String currentPassword,
        @Schema(description = "новый пароль")
        @NotBlank
        @Min(8)
        @Max(16)
        String newPassword
) {
}
