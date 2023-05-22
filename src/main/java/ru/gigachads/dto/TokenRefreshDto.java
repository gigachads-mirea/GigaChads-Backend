package ru.gigachads.dto;

import javax.validation.constraints.NotBlank;

/**
 * Описание класса
 */
public class TokenRefreshDto {
    @NotBlank
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}