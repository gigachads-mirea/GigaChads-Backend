package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.Review;

/**
 * Описание класса
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
