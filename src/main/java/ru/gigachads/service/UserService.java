package ru.gigachads.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gigachads.dto.RegisterRequestDto;
import ru.gigachads.dto.UserDto;
import ru.gigachads.entity.Role;
import ru.gigachads.entity.User;
import ru.gigachads.exception.EntityNotFoundException;
import ru.gigachads.mapper.UserMapper;
import ru.gigachads.repository.RoleRepository;
import ru.gigachads.repository.ServerRepository;
import ru.gigachads.repository.UserRepository;

/**
 * Описание класса
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ServerRepository serverRepository;

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new EntityNotFoundException(String.format("User with username = %s", username)));
    }

    public UserDto create(RegisterRequestDto userDto) {
        Role userRole = roleRepository.findByName("User");
        User user = User.builder()
            .username(userDto.getUsername())
            .password(passwordEncoder.encode(userDto.getPassword()))
            .email(userDto.getEmail())
            .active(true)
            .role(userRole)
            .build();
        return userMapper.toUserDto(userRepository.save(user));
    }
}
