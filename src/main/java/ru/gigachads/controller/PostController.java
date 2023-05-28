package ru.gigachads.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.gigachads.controller.api.PostApi;
import ru.gigachads.dto.CommentDto;
import ru.gigachads.dto.PostDto;
import ru.gigachads.entity.Post;
import ru.gigachads.entity.User;
import ru.gigachads.security.JwtTokenProvider;
import ru.gigachads.service.CommentService;
import ru.gigachads.service.PostService;
import ru.gigachads.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Описание класса
 */
@Controller
@RequiredArgsConstructor
public class PostController implements PostApi {

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;
    private final JwtTokenProvider jwtTokenProvider;


    public ResponseEntity<?> create(PostDto postDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> addComment(Long id, CommentDto dto, HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        String username = jwtTokenProvider.getUsernameFromToken(token);
        User user = userService.loadUserByUsername(username);
        Post post = postService.findById(id);
        return ResponseEntity.ok(commentService.create(dto, post, user));
    }
}
