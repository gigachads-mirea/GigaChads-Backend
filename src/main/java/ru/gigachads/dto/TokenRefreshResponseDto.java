package ru.gigachads.dto;

import lombok.Getter;

/**
 * Описание класса
 */
@Getter
public class TokenRefreshResponseDto {
    private String accessToken;
    private String refreshToken;

    public TokenRefreshResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}