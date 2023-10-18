package com.team2.flea_market.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Schema(name = "Login")
public record LoginDto(
        @Schema(description = "логин")
        @NotBlank
        @Min(4)
        @Max(32)
        String username,
        @Schema(description = "пароль")
        @NotBlank
        @Min(8)
        @Max(16)
        String password
) {
}
