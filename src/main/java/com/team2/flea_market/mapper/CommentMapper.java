package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

    /**
     * Используй для маппинг в {@link Comment}
     *
     * @param commentDto {@link CommentDto}
     * @return {@link Comment}
     */
    @Mapping(target = "id", source = "pk")
    @Mapping(target = "user.id", source = "author")
    @Mapping(target = "user.firstName", source = "authorFirstName")
    @Mapping(target = "user.image", source = "authorImage")
    Comment toEntity(CommentDto commentDto);

    /**
     * Используй для маппинг в {@link Comment} при апдейте
     *
     * @param updateCommentDto {@link CreateOrUpdateCommentDto}
     * @param comment {@link Comment}
     * @return {@link Comment}
     */
    Comment toUpdatedOrCreateComment(CreateOrUpdateCommentDto updateCommentDto, @MappingTarget Comment comment);

    /**
     * Используй для маппинг в {@link CommentDto}
     *
     * @param comment {@link Comment}
     * @return {@link Comment}
     */
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "user.id")
    @Mapping(target = "authorFirstName", source = "user.firstName")
    @Mapping(target = "authorImage", source = "user.image")
    CommentDto toDto(Comment comment);
}


