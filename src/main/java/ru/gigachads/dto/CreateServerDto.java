package ru.gigachads.dto;

import lombok.AllArgsConstructor;

/**
 * Описание класса
 */
@AllArgsConstructor
public class CreateServerDto {

    private String ipAddress;

    private int capacity;

    private String region;

    private int ping;

    private boolean antiCheat;

    private float rating;

    private Long gameId;
}
