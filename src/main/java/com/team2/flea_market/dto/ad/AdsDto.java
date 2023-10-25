package com.team2.flea_market.dto.ad;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "Ads")
public record AdsDto(
        @Schema(description = "общее количество объявлений")
        Integer count,
        @Schema(description = "список всех объявлений")
        List<AdDto> results
) {
}
