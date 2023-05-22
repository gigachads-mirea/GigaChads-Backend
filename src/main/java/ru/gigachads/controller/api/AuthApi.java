package ru.gigachads.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gigachads.dto.AuthRequestDto;
import ru.gigachads.dto.AuthResponseDto;
import ru.gigachads.dto.RegisterRequestDto;
import ru.gigachads.dto.TokenRefreshDto;
import ru.gigachads.dto.TokenRefreshResponseDto;
import ru.gigachads.dto.UserDto;

import javax.validation.Valid;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/auth")
public interface AuthApi {

    @PostMapping("/register")
    ResponseEntity<UserDto> register(
        @RequestBody @Valid RegisterRequestDto requestDto
    );

    @PostMapping("/login")
    ResponseEntity<AuthResponseDto> authenticate(
        @RequestBody @Valid AuthRequestDto requestDto
    );

    @PostMapping("/refresh")
    ResponseEntity<TokenRefreshResponseDto> refreshToken(
        @Valid @RequestBody TokenRefreshDto request
    );
}
