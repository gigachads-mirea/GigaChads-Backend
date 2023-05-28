package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.Game;

/**
 * Описание класса
 */
public interface GameRepository extends JpaRepository<Game, Long> {
}
