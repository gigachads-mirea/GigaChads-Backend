package ru.gigachads.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gigachads.dto.AuthRequestDto;
import ru.gigachads.dto.RegisterRequestDto;

import javax.validation.Valid;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/auth")
public interface AuthApi {

    @PostMapping("/register")
    ResponseEntity<?> register(
        @RequestBody @Valid RegisterRequestDto requestDto
    );

    @PostMapping("/login")
    ResponseEntity<?> authenticate(
        @RequestBody @Valid AuthRequestDto requestDto
    );
}
