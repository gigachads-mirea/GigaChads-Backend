package ru.gigachads.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gigachads.entity.Post;
import ru.gigachads.exception.EntityNotFoundException;
import ru.gigachads.repository.PostRepository;

/**
 * Описание класса
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post findById(Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Post with id = %s", id)));
    }
}
