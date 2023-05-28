package ru.gigachads.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gigachads.controller.api.ServerApi;
import ru.gigachads.dto.CreateServerDto;
import ru.gigachads.security.JwtTokenProvider;
import ru.gigachads.service.ServerService;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Описание класса
 */
@RestController
@RequiredArgsConstructor
public class ServerController implements ServerApi {

    private final JwtTokenProvider jwtTokenProvider;

    private final ServerService serverService;

    @Override
    public ResponseEntity<?> create(CreateServerDto createServerDto, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(CreateServerDto createServerDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getOne(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> compare(Set<Long> ids) {
        return null;
    }

    @Override
    public ResponseEntity<?> addFavorite(Long id, HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        String username = jwtTokenProvider.getUsernameFromToken(token);
        return ResponseEntity.ok(serverService.addFavorite(username, id));
    }
}
