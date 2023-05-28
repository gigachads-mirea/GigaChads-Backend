package ru.gigachads.dto;

/**
 * Описание класса
 */
public record CreateServerDto (
    String ipAddress,

    String title,

    String description,

    int capacity,

    Long regionId,

    int ping,

    boolean antiCheat,

    boolean isModded,

    Long gameId
) {

}
