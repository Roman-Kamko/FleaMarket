package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommentMapperTest {

    private final CommentMapper commentMapper = new CommentMapperImpl();

    private final Comment comment = prepearComment();
    private final Comment newComment = prepearNewComment();
    private final CommentDto commentDto = prepearCommentDto();
    private final CreateOrUpdateCommentDto createOrUpdateCommentDto = new CreateOrUpdateCommentDto("New_Text");

    @Test
    void toEntity() {
        assertThat(commentMapper.toEntity(createOrUpdateCommentDto)).isEqualTo(newComment);
        System.out.println(commentMapper.toEntity(createOrUpdateCommentDto));
    }

    @Test
    void toUpdatedOrCreateComment() {
        assertThat(commentMapper.toUpdatedComment(createOrUpdateCommentDto, comment).getText()).isEqualTo("New_Text");
    }

    @Test
    void toDto() {
        assertThat(commentMapper.toDto(comment)).isEqualTo(commentDto);
    }

    private Comment prepearComment() {
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

    private Comment prepearNewComment() {
        return Comment.builder()
                .id(null)
                .text("New_Text")
                .createdAt(null)
                .user(null)
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