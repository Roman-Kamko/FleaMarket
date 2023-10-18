package com.team2.flea_market.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Schema(name = "CreateOrUpdateComment")
public record CreateOrUpdateCommentDto(
        @Schema(description = "текст комментария")
        @Min(8)
        @Max(64)
        String text
) {
}
