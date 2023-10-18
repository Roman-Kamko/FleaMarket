package com.team2.flea_market.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Schema(name = "UpdateUser")
public record UpdateUserDto(
        @Schema(description = "имя пользователя")
        @Min(3)
        @Max(10)
        String firstName,
        @Schema(description = "фамилия пользователя")
        @Min(3)
        @Max(10)
        String lastName,
        @Schema(description = "телефон пользователя")
        @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
        String phone
) {
}
