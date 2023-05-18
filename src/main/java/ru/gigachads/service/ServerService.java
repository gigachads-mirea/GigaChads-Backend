package ru.gigachads.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.gigachads.entity.Server;
import ru.gigachads.repository.ServerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class ServerService {
    private final ServerRepository serverRepository;

    public List<Server> getAll() { return serverRepository.findAll(); }

    @Nullable
    public Server getOne(Long id) {
        Server server = null;

        try { server = serverRepository.getById(id); }
        catch (EntityNotFoundException ignored) {}

        return server;
    }

    public boolean deleteOne(Long id) {
        try {
            serverRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
