package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.Comment;

/**
 * Описание класса
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
