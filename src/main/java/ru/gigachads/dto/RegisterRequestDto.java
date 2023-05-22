package ru.gigachads.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Описание класса
 */
@Getter
@Setter
public class RegisterRequestDto {

    private String username;

    private String password;

    private String email;
}
