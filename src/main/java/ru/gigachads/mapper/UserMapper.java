package ru.gigachads.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import ru.gigachads.dto.UserDto;
import ru.gigachads.entity.User;

/**
 * Описание класса
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
}