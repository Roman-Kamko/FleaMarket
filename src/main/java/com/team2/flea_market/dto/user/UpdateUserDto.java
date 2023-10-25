package com.team2.flea_market.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Schema(name = "UpdateUser")
public record UpdateUserDto(
        @Length(min = 3, max = 10, message = "некорректный ввод имени: ${validatedValue}")
        @Schema(description = "имя пользователя", minimum = "3", maximum = "10", example = "Иван")
        String firstName,
        @Length(min = 3, max = 10, message = "некорректный ввод фамилии: ${validatedValue}")
        @Schema(description = "фамилия пользователя", minimum = "3", maximum = "10", example = "Иванов")
        String lastName,
        @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}", message = "некорректный ввод телефона: ${validatedValue}")
        @Schema(description = "телефон пользователя", pattern = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}", example = "+7(911)119-23-32")
        String phone
) {
}
