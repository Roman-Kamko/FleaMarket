package com.team2.flea_market.controller;

import com.team2.flea_market.dto.comment.CommentDto;
import com.team2.flea_market.dto.comment.CommentsDto;
import com.team2.flea_market.dto.comment.CreateOrUpdateCommentDto;
import com.team2.flea_market.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@Tag(name = "Комментарии")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "Получение всех комментариев объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = CommentsDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDto> findAllAdComments(@PathVariable @Parameter(description = "id объявления") Integer id) {
        return ResponseEntity.ok(commentService.findAllAdComments(id));
    }

    @Operation(summary = "Добавление комментария к объявлению")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = CommentDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable @Parameter(description = "id объявления") Integer id,
                                                    @RequestBody @Valid CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        return ResponseEntity.ok(new CommentDto(1, "", "", 1L, 1, ""));
    }

    @Operation(summary = "Удаление комментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteAdComment(@PathVariable @Parameter(description = "id объявления") Integer adId,
                                             @PathVariable @Parameter(description = "id комментария") Integer commentId) {
        commentService.deleteAdComment(adId, commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @Operation(summary = "Обновление комментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = CommentDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable @Parameter(description = "id объявления") Integer adId,
                                                    @PathVariable @Parameter(description = "id комментария") Integer commentId,
                                                    @RequestBody @Valid CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        return ResponseEntity.ok(commentService.updateComment(adId, commentId, createOrUpdateCommentDto));
    }
}
