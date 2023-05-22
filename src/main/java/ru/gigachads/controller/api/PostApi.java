package ru.gigachads.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gigachads.dto.CommentDto;
import ru.gigachads.dto.PostDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Описание класса
 */
@RequestMapping("/ap/v1/posts")
public interface PostApi {

    @PostMapping("")
    ResponseEntity<?> create(
        @RequestBody @Valid PostDto postDto
    );

    @PostMapping("/{id}/comment")
    ResponseEntity<?> addComment(
        @PathVariable Long id,
        @RequestBody CommentDto dto,
        HttpServletRequest request
    );
}
