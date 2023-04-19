package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.Server;

/**
 * Описание класса
 */
public interface ServerRepository extends JpaRepository<Server, Long> {
}
