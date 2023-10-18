package com.team2.flea_market.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "Comments")
public record CommentsDto(
        @Schema(description = "общее количество комментариев")
        Integer count,
        @Schema(description = "список всех комментариев")
        List<CommentDto> results
) {
}
