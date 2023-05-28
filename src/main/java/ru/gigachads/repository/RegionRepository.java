package ru.gigachads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gigachads.entity.Region;

/**
 * Описание класса
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
