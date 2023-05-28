package ru.gigachads.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gigachads.dto.CreateServerDto;
import ru.gigachads.dto.ServerDto;
import ru.gigachads.entity.Game;
import ru.gigachads.entity.Region;
import ru.gigachads.entity.Server;
import ru.gigachads.entity.User;
import ru.gigachads.exception.EntityNotFoundException;
import ru.gigachads.mapper.ServerMapper;
import ru.gigachads.repository.GameRepository;
import ru.gigachads.repository.RegionRepository;
import ru.gigachads.repository.ServerRepository;
import ru.gigachads.repository.UserRepository;

import java.util.List;

/**
 * Описание класса
 */
@Service
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;
    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final GameRepository gameRepository;
    private final ServerMapper serverMapper;

    public Server addFavorite(String username, Long serverId) {
        Server server = serverRepository.findById(serverId)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Server with id = %s", serverId)));

        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new EntityNotFoundException(String.format("User with username = %s", username)));

        user.addFavorite(server);
        userRepository.save(user);
        return server;
    }

    public Server create(CreateServerDto dto, String username) {
        Region region = regionRepository.findById(dto.regionId())
            .orElseThrow(() -> new EntityNotFoundException(String.format("Region with id = %s", dto.regionId())));

        Game game = gameRepository.findById(dto.gameId())
            .orElseThrow(() -> new EntityNotFoundException(String.format("Game with id = %s", dto.gameId())));

        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new EntityNotFoundException(String.format("User with username = %s", username)));

        Server server = serverMapper.toServerEntity(dto);

        server.setGame(game);
        server.setRegion(region);
        server.setOwner(user);
        server.setValidated(false);

        return serverRepository.save(server);
    }

    public List<ServerDto> getInvalidatedServers() {
        return serverMapper.toServerDtoList(serverRepository.findByValidated(false));
    }

    public ServerDto validateServer(Long id) {
        Server server = serverRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Server with id = %s", id)));

        server.setValidated(true);
        return serverMapper.toServerDto(serverRepository.save(server));
    }
}
