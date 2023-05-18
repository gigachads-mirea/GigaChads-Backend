package ru.gigachads.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gigachads.entity.Server;
import ru.gigachads.repository.ServerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServerService {
    private final ServerRepository serverRepository;

    public List<Server> getAll() { return serverRepository.findAll(); }
}
