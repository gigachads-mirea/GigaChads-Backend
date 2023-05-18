package ru.gigachads.service;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.gigachads.entity.Server;
import ru.gigachads.repository.ServerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ServerService {
    private final ServerRepository serverRepository;

    public static int FILTER_IP_ADDRESS_FLAG = 1;
    public static int FILTER_CAPACITY_FLAG = 2;
    public static int FILTER_REGION_FLAG = 4;
    public static int FILTER_PING_FLAG = 8;
    public static int FILTER_ANTI_CHEAT_FLAG = 16;
    public static int FILTER_RATING_FLAG = 32;
    public static int FILTER_GAME_ID_FLAG = 64;

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

    @Nullable
    public Server getFiltered(int filterFlags, String value) {
        if ((filterFlags & FILTER_IP_ADDRESS_FLAG) == FILTER_IP_ADDRESS_FLAG)
            return getByIpAddress(value);
//        else
            // TODO
        return null;
    }

    @Nullable
    private Server getByIpAddress(String value) {
        val matches = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$", Pattern.CASE_INSENSITIVE)
            .matcher(value)
            .find();

        return matches ? serverRepository.getByIpAddress(value) : null;
    }
}
