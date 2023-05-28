package ru.gigachads.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gigachads.dto.ServerDto;

/**
 * Описание класса
 */
@RequestMapping("/api/v1/admin")
public interface AdminApi {

    @Operation(summary = "Validates server claiming to be added to service")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = ServerDto.class)))}
        ),
        @ApiResponse(
            responseCode = "401", description = "The token was not provided or is not valid", content = @Content
        ),
        @ApiResponse(
            responseCode = "403", description = "No permissions for this operation", content = @Content
        ),
    })
    @PostMapping("/validate/{id}")
    ResponseEntity<ServerDto> validateServer(
        @PathVariable Long id
    );

    @Operation(summary = "Returns list of servers claiming to be ")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", description = "OK",
            content = {@Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = ServerDto.class)))}
        ),
        @ApiResponse(
            responseCode = "401", description = "The token was not provided or is not valid", content = @Content
        ),
        @ApiResponse(
            responseCode = "403", description = "No permissions for this operation", content = @Content
        ),
    })
    @GetMapping("/servers")
    ResponseEntity<?> getServersForValidation();

}
