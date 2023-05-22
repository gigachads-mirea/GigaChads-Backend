package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.Server;

import java.util.List;

/**
 * Описание класса
 */
public interface ServerRepository extends JpaRepository<Server, Long> {

    List<Server> findByValidated(boolean validated);
}
