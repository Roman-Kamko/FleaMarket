package com.team2.flea_market.dto.ad;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CreateOrUpdateAdDto(
        @NotBlank
        @Length(min = 4, max = 32, message = "некорректная длина заголовка: ${validatedValue}")
        @Schema(description = "заголовок объявления", minimum = "4", maximum = "32")
        String title,
        @NotNull
        @Min(0)
        @Max(10_000_000)
        @Schema(description = "цена", minimum = "0", maximum = "10_000_000")
        Integer price,
        @Length(min = 8, max = 64, message = "некорректная длина описания: ${validatedValue}")
        @Schema(description = "описание объявления", minimum = "8", maximum = "64")
        String description
) {
}
