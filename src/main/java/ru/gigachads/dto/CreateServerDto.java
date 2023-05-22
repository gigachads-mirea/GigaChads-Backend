package ru.gigachads.dto;

/**
 * Описание класса
 */
public record CreateServerDto (
    String ipAddress,

    int capacity,

    Long regionId,

    int ping,

    boolean antiCheat,

    boolean isModded,

    Long gameId
) {

}
