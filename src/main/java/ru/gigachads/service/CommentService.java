package ru.gigachads.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gigachads.dto.CommentDto;
import ru.gigachads.entity.Comment;
import ru.gigachads.entity.Post;
import ru.gigachads.entity.User;
import ru.gigachads.repository.CommentRepository;

import java.time.LocalDateTime;

/**
 * Описание класса
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public Comment create(CommentDto dto, Post post, User user) {
        Comment comment = Comment.builder()
            .post(post)
            .author(user)
            .text(dto.text())
            .writtenAt(LocalDateTime.now())
            .build();
        return commentRepository.save(comment);
    }
}
