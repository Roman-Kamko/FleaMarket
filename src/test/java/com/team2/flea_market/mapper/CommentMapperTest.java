package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommentMapperTest {

    private final CommentMapper commentMapper = new CommentMapperImpl();

    private final Comment comment = prepearNewComment();

    private final CommentDto commentDto = prepearCommentDto();

    @Test
    void toEntity() {
        assertThat(commentMapper.toEntity(commentDto)).isEqualTo(comment);
    }

    @Test
    void toUpdatedOrCreateComment() {
        CreateOrUpdateCommentDto createOrUpdateCommentDto = new CreateOrUpdateCommentDto("New_Text");
        assertThat(commentMapper.toUpdatedOrCreateComment(createOrUpdateCommentDto, comment).getText()).isEqualTo("New_Text");
    }

    @Test
    void toDto() {
        assertThat(commentMapper.toDto(comment)).isEqualTo(commentDto);
    }

    private Comment prepearNewComment() {
        return Comment.builder()
                .id(1)
                .text("comment")
                .createdAt(1L)
                .user(User.builder().id(1)
                        .email(null)
                        .password(null)
                        .firstName("ewq")
                        .lastName(null)
                        .phone(null)
                        .role(null)
                        .image("image")
                        .ads(null)
                        .comments(null)
                        .build())
                .ad(null)
                .build();
    }

    private CommentDto prepearCommentDto() {
        return CommentDto.builder()
                .pk(1)
                .author(1)
                .authorFirstName("ewq")
                .authorImage("image")
                .text("comment")
                .createdAt(1L)
                .build();
    }
}