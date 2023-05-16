package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.Post;

/**
 * Описание класса
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
