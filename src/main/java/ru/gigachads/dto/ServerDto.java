package ru.gigachads.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.gigachads.entity.Game;
import ru.gigachads.entity.Region;

/**
 * Описание класса
 */
@Getter
@Setter
@Builder
public class ServerDto {

    private String ipAddress;

    private int capacity;

    private int currentOnline;

    private Region region;

    private int ping;

    private boolean antiCheat;

    private boolean isModded;

    private float rating;

    private Game game;
}
