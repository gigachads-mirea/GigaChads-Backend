package ru.gigachads.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gigachads.controller.api.AuthApi;
import ru.gigachads.dto.AuthRequestDto;
import ru.gigachads.dto.AuthResponseDto;
import ru.gigachads.dto.RegisterRequestDto;
import ru.gigachads.dto.TokenRefreshDto;
import ru.gigachads.dto.TokenRefreshResponseDto;
import ru.gigachads.dto.UserDto;
import ru.gigachads.entity.RefreshToken;
import ru.gigachads.entity.User;
import ru.gigachads.exception.TokenRefreshException;
import ru.gigachads.security.JwtTokenProvider;
import ru.gigachads.service.RefreshTokenService;
import ru.gigachads.service.UserService;

import javax.validation.Valid;

/**
 * Описание класса
 */
@RestController
@AllArgsConstructor
public class AuthController implements AuthApi {
    private final UserService userService;
    private final AuthenticationManager manager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenService refreshTokenService;

    public ResponseEntity<UserDto> register(@RequestBody @Valid RegisterRequestDto userDTO) {
        try {
            userService.loadUserByUsername(userDTO.getUsername());
            // todo Some kind of exception
        } catch(UsernameNotFoundException ex) {
            return ResponseEntity.ok(userService.create(userDTO));
        }
        return null;
    }

    public ResponseEntity<AuthResponseDto> authenticate(@RequestBody @Valid AuthRequestDto request) throws UsernameNotFoundException {
        String username = request.getUsername();
        manager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));
        User user = userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenProvider.generateToken(user);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());
        AuthResponseDto response = AuthResponseDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .accessToken(token)
            .refreshToken(refreshToken.getToken())
            .role(user.getRole().toString())
            .build();
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<TokenRefreshResponseDto> refreshToken(@Valid @RequestBody TokenRefreshDto request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
            .map(refreshTokenService::verifyExpiration)
            .map(RefreshToken::getUser)
            .map(user -> {
                String token = jwtTokenProvider.generateToken(user);
                return ResponseEntity.ok(new TokenRefreshResponseDto(token, requestRefreshToken));
            })
            .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                "Refresh token is not found!"));
    }
}
