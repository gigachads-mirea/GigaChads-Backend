package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gigachads.entity.User;

/**
 * Описание класса
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
