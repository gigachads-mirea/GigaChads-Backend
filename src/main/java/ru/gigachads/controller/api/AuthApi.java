package ru.gigachads.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Register a new account")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))}
        ),
        @ApiResponse(
            responseCode = "400", description = "Some fields are not valid", content = @Content
        ),
    })
    @PostMapping("/register")
    ResponseEntity<UserDto> register(
        @RequestBody @Valid RegisterRequestDto requestDto
    );

    @Operation(summary = "Log into account")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = AuthResponseDto.class)))}
        ),
        @ApiResponse(
            responseCode = "401", description = "Bad credentials", content = @Content
        ),
    })
    @PostMapping("/login")
    ResponseEntity<AuthResponseDto> authenticate(
        @RequestBody @Valid AuthRequestDto requestDto
    );

    @Operation(summary = "Get new access token with active refresh token")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = TokenRefreshResponseDto.class)))}
        ),
        @ApiResponse(
            responseCode = "403", description = "Bad credentials", content = @Content
        ),
    })
    @PostMapping("/refresh")
    ResponseEntity<TokenRefreshResponseDto> refreshToken(
        @Valid @RequestBody TokenRefreshDto request
    );
}
