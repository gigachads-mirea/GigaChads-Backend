package ru.gigachads.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import ru.gigachads.dto.CreateServerDto;
import ru.gigachads.dto.ServerDto;
import ru.gigachads.entity.Server;

import java.util.List;

/**
 * Описание класса
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = "spring")
public interface ServerMapper {

    Server toServerEntity(CreateServerDto dto);

    ServerDto toServerDto(Server server);

    List<ServerDto> toServerDtoList(List<Server> serverList);
}
