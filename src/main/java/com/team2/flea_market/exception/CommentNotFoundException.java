package com.team2.flea_market.exception;

public class CommentNotFoundException extends RuntimeException {

    private final Integer commentId;

    public CommentNotFoundException(Integer commentId) {this.commentId=commentId;}

    @Override
    public String getMessage() {
        return "комментарий с ID %d не найден".formatted(commentId);
    }
    }

