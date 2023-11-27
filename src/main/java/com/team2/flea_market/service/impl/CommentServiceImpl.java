package com.team2.flea_market.service.impl;


import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CommentsDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.entity.User;
import com.team2.flea_market.exception.AdNotFoundException;
import com.team2.flea_market.exception.CommentNotFoundException;
import com.team2.flea_market.exception.EntityConversionException;
import com.team2.flea_market.mapper.CommentMapper;
import com.team2.flea_market.repository.AdRepository;
import com.team2.flea_market.repository.CommentRepository;
import com.team2.flea_market.security.SecurityPermission;
import com.team2.flea_market.service.CommentService;
import com.team2.flea_market.service.SecurityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final SecurityService securityService;
    private final AdRepository adRepository;
    private final SecurityPermission permission;


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

        User currentUser = securityService.getCurrentUser();

        return Optional.of(createOrUpdateCommentDto)
                .map(dto -> {
                    Comment comment = commentMapper.toEntity(dto);
                    long currentTimeMillis = System.currentTimeMillis();
                    comment.setAd(adRepository.findById(id)
                            .orElseThrow(() -> new AdNotFoundException(id)));
                    comment.setText(dto.text());
                    comment.setCreatedAt(currentTimeMillis);
                    comment.setUser(currentUser);
                    commentRepository.save(comment);
                    return commentMapper.toDto(comment);
                })
                .orElseThrow(() -> new EntityConversionException(
                        "Ошибка преобразования, при попытке создать комментарий \"%s\" пользователем \"%s\""
                                .formatted(createOrUpdateCommentDto.text(), currentUser.getEmail()))
                );
    }

    @Override
    @Transactional
    public void deleteAdComment(Integer adId, Integer commentId) {
        User currentUser = securityService.getCurrentUser();
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
        permission.verifyCommentPermissions(comment, currentUser);
        commentRepository.delete(comment);
    }

    @Override
    @Transactional
    public CommentDto updateComment(Integer adId, Integer commentId, CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        User currentUser = securityService.getCurrentUser();
        return commentRepository.findById(commentId)
                .map(comment -> {
                    permission.verifyCommentPermissions(comment, currentUser);
                    commentMapper.toUpdatedComment(createOrUpdateCommentDto, comment);
                    return commentRepository.save(comment);
                })
                .map(commentMapper::toDto)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
    }
}
