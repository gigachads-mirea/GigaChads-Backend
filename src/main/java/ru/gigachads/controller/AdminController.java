package ru.gigachads.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.gigachads.controller.api.AdminApi;
import ru.gigachads.service.ServerService;

/**
 * Описание класса
 */
@RestController
@RequiredArgsConstructor
public class AdminController implements AdminApi {
    private final ServerService serverService;

    @Override
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<?> validateServer(Long id) {
        return ResponseEntity.ok(serverService.validateServer(id));
    }

    @Override
    public ResponseEntity<?> getServersForValidation() {
        return null;
    }
}
