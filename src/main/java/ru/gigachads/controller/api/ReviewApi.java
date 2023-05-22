package ru.gigachads.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gigachads.dto.ReviewDto;

import javax.validation.Valid;

/**
 * Описание класса
 */
@RequestMapping("/ap/v1/reviews")
public interface ReviewApi {

    @PostMapping("")
    ResponseEntity<?> create(
        @RequestBody @Valid ReviewDto reviewDto
    );
}
