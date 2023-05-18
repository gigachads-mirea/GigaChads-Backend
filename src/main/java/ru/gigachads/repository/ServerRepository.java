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
    Server getByIpAddress(String ipAddress); // ip address is unique for each server?

//    @Query(value = "select * from servers where capacity = ?1", nativeQuery = true)
//    List<Server> getByCapacity(int capacity); // TODO: remove these
//
//    @Query(value = "select * from servers where region = ?1", nativeQuery = true)
//    List<Server> getByRegion(String region);
//
//    @Query(value = "select * from servers where antiCheat = ?1", nativeQuery = true)
//    List<Server> getByAntiCheat(boolean antiCheat);
//
//    @Query(value = "select * from servers where rating = ?1", nativeQuery = true)
//    List<Server> getByRating(float rating);
//
//    @Query(value = "select * from servers where gameId = ?1", nativeQuery = true)
//    List<Server> getByGameId(float gameId);
}
