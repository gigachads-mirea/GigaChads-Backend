package ru.gigachads.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gigachads.dto.CreateServerDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/servers")
public interface ServerApi {

    @PostMapping("")
    ResponseEntity<?> create(
        @RequestBody @Valid CreateServerDto createServerDto,
        HttpServletRequest request
    );

    @PatchMapping("")
    ResponseEntity<?> update(
        @RequestBody @Valid CreateServerDto createServerDto
    );

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(
        @PathVariable Long id
    );

    @GetMapping("")
    ResponseEntity<?> getAll();

    @GetMapping("/{id}")
    ResponseEntity<?> getOne(
        @PathVariable Long id
    );

    @GetMapping("/compare")
    ResponseEntity<?> compare(
        @RequestParam(value = "ids") Set<Long> ids
    );

    @PostMapping("/{id}/favorites")
    ResponseEntity<?> addFavorite(
        @PathVariable Long id,
        HttpServletRequest request
    );

}
