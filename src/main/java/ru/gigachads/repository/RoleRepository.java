package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gigachads.entity.Role;

/**
 * Описание класса
 */
@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
