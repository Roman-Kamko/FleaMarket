package com.team2.flea_market.service.impl;


import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CommentsDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.exception.CommentNotFoundException;
import com.team2.flea_market.mapper.CommentMapper;
import com.team2.flea_market.repository.CommentRepository;
import com.team2.flea_market.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    @Override
    public CommentsDto findAllAdComments(Integer id) {
        List<CommentDto> results = commentRepository.findAllByAd_Id(id).stream()
                .map(commentMapper::toDto)
                .toList();
        return commentMapper.toCommentsDto(results);
    }

    @Override
    @Transactional
    public CommentDto createComment(Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDto) {

        return null;
    }

    @Override
    @Transactional
    public void deleteAdComment(Integer adId, Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
        commentRepository.delete(comment);

    }

    @Override
    @Transactional
    public CommentDto updateComment(Integer adId, Integer commentId, CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        return commentRepository.findById(commentId)
                .map(comment -> {
                    commentMapper.toUpdatedComment(createOrUpdateCommentDto, comment);
                    return commentRepository.save(comment);
                })
                .map(commentMapper::toDto)
                .orElseThrow(() -> new CommentNotFoundException(commentId));

    }
}
