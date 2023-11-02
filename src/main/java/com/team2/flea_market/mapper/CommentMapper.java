package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.entity.Image;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

    /**
     * Используй для маппинг в {@link Comment} при создании
     *
     * @param commentDtoIn {@link CreateOrUpdateCommentDto}
     * @return {@link Comment}
     */
    Comment toEntity(CreateOrUpdateCommentDto commentDtoIn);

    /**
     * Используй для маппинг в {@link Comment} при апдейте
     *
     * @param updateCommentDto {@link CreateOrUpdateCommentDto}
     * @param comment {@link Comment}
     */
    void toUpdatedComment(CreateOrUpdateCommentDto updateCommentDto, @MappingTarget Comment comment);

    /**
     * Используй для маппинг в {@link CommentDto}
     *
     * @param comment {@link Comment}
     * @return {@link Comment}
     */
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "user.id")
    @Mapping(target = "authorFirstName", source = "user.firstName")
    @Mapping(target = "authorImage", source = "user.image", qualifiedByName = "imageMapping")
    CommentDto toDto(Comment comment);

    @Named("imageMapping")
    default String imageMapping(Image image) {
        if (image == null) {
            return null;
        }
        return "users/image/" + image.getId();
    }

}


