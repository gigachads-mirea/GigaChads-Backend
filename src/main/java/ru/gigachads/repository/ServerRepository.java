package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import ru.gigachads.entity.Server;

/**
 * Описание класса
 */
public interface ServerRepository extends JpaRepository<Server, Long> {

    @Nullable
    @Query(value = "select * from servers where ipAddress = ?1", nativeQuery = true)
    Server getByIpAddress(String ipAddress);
}
