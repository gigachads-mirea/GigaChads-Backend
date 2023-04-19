package ru.gigachads.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/admin")
public interface AdminApi {

    @PostMapping("/validate/{id}")
    ResponseEntity<?> validateServer(
        @PathVariable Long id
    );

    @GetMapping("/servers")
    ResponseEntity<?> getServersForValidation();

}
