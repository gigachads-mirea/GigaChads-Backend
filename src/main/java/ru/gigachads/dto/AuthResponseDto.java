package ru.gigachads.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * Описание класса
 */
@Builder
@Getter
public class AuthResponseDto {
    Long id;
    String username;
    String accessToken;
    String refreshToken;
    String role;
}
