package com.team2.flea_market.dto.auth;

import com.team2.flea_market.dto.user.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@Schema(name = "Register")
public record RegisterDto(
        @NotBlank
        @Length(min = 4, max = 32, message = "некорректная длина логина: ${validatedValue}")
        @Schema(description = "логин", minimum = "4", maximum = "32", example = "user@gmail.com")
        String username,
        @NotBlank
        @Length(min = 8, max = 16, message = "некорректная длина пароля: ${validatedValue}")
        @Schema(description = "текущий пароль", minimum = "8", maximum = "16", example = "password")
        String password,
        @NotBlank
        @Length(min = 2, max = 16, message = "некорректная длина имени пользователя: ${validatedValue}")
        @Schema(description = "имя пользователя", minimum = "2", maximum = "16", example = "Иван")
        String firstName,
        @NotBlank
        @Length(min = 2, max = 16, message = "некорректная длина фамилии пользователя: ${validatedValue}")
        @Schema(description = "фамилия пользователя", minimum = "2", maximum = "16", example = "Иванов")
        String lastName,
        @NotBlank
        @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}", message = "некорректный ввод телефона: ${validatedValue}")
        @Schema(description = "телефон пользователя", pattern = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}", example = "+7(911)119-23-32")
        String phone,

        Role role
) {
}
