package com.team2.flea_market.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Schema(name = "CreateOrUpdateComment")
public record CreateOrUpdateCommentDto(
        @Length(min = 8, max = 64, message = "некорректная длина текста комментария: ${validatedValue}")
        @Schema(description = "текст комментария", minimum = "8", maximum = "64", example = "текст комментария")
        String text
) {
}
