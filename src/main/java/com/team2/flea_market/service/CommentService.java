package com.team2.flea_market.service;

import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CommentsDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;

public interface CommentService {

    CommentsDto findAllAdComments(Integer id);

    CommentDto createComment(Integer id,CreateOrUpdateCommentDto createOrUpdateCommentDto);

    void deleteAdComment(Integer adId, Integer commentId);

    CommentDto updateComment (Integer adId, Integer commentId, CreateOrUpdateCommentDto createOrUpdateCommentDto);

}
