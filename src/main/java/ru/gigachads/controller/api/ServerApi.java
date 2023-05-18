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

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/servers")
public interface ServerApi {

    @PostMapping("")
    ResponseEntity<?> create(
        @RequestBody @Valid CreateServerDto createServerDto
    );

    @PatchMapping("")
    ResponseEntity<?> update(
        @RequestBody @Valid CreateServerDto createServerDto
    );

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(
        @PathVariable Long id
    );

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<CreateServerDto>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<?> getOne(
        @PathVariable Long id
    );

    @GetMapping("/compare")
    ResponseEntity<?> compare(
        @RequestParam(value = "ids") Set<Long> ids
    );
}
