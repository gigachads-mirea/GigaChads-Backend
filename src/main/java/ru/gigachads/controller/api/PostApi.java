package ru.gigachads.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gigachads.dto.CommentDto;
import ru.gigachads.dto.PostDto;
import ru.gigachads.entity.Comment;
import ru.gigachads.entity.Post;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/posts")
public interface PostApi {

    @Operation(summary = "Create new post")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Post.class)))}
        ),
        @ApiResponse(
            responseCode = "400", description = "Some fields are not valid", content = @Content
        ),
        @ApiResponse(
            responseCode = "401", description = "The token was not provided or is not valid", content = @Content
        ),
    })
    @PostMapping("")
    ResponseEntity<?> create(
        @RequestBody @Valid PostDto postDto
    );

    @Operation(summary = "Add comment to post")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Comment.class)))}
        ),
        @ApiResponse(
            responseCode = "400", description = "Some fields are not valid", content = @Content
        ),
        @ApiResponse(
            responseCode = "401", description = "The token was not provided or is not valid", content = @Content
        ),
        @ApiResponse(
            responseCode = "403", description = "No permissions for this operation", content = @Content
        ),
    })
    @PostMapping("/{id}/comment")
    ResponseEntity<Comment> addComment(
        @PathVariable Long id,
        @RequestBody CommentDto dto,
        HttpServletRequest request
    );
}
