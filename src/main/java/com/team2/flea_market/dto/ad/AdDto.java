package com.team2.flea_market.dto.ad;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Ad")
public record AdDto(
        @Schema(description = "id автора объявления")
        Integer author,
        @Schema(description = "ссылка на картинку объявления")
        String image,
        @Schema(description = "id объявления")
        Integer pk,
        @Schema(description = "цена")
        Integer price,
        @Schema(description = "заголовок объявления")
        String title
) {
}
