package com.team2.flea_market.dto.ad;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CreateOrUpdateAdDto(
        @Schema(description = "заголовок объявления")
        @NotBlank
        @Min(4)
        @Max(32)
        String title,
        @Schema(description = "цена")
        @NotNull
        @Min(0)
        @Max(10_000_000)
        Integer price,
        @Schema(description = "описание объявления")
        @Min(8)
        @Max(64)
        String description
) {
}
