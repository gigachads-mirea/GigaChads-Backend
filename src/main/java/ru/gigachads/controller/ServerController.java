package ru.gigachads.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.gigachads.controller.api.ServerApi;
import ru.gigachads.dto.CreateServerDto;
import ru.gigachads.entity.Server;
import ru.gigachads.service.ServerService;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class ServerController implements ServerApi {
    private final ServerService serverService;

    private static CreateServerDto serverToCreateServer(Server server) {
        return new CreateServerDto(); // TODO
    }

    @Override
    public ResponseEntity<?> create(CreateServerDto createServerDto) { throw new RuntimeException("not implemented"); }

    @Override
    public ResponseEntity<?> update(CreateServerDto createServerDto) { throw new RuntimeException("not implemented"); }

    @Override
    public ResponseEntity<?> delete(Long id) { throw new RuntimeException("not implemented"); }

    @Override
    public ResponseEntity<List<CreateServerDto>> getAll() {
        return ResponseEntity.ok(serverService.getAll().stream().map(ServerController::serverToCreateServer).toList());
    }

    @Override
    public ResponseEntity<CreateServerDto> getOne(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> compare(Set<Long> ids) { throw new RuntimeException("not implemented"); }
}
