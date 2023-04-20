package ru.gigachads.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Описание класса
 */
public enum Role {
    USER(Set.of(Permission.USERS_PERMISSION)),
    ADMIN(Set.of(Permission.ADMIN_PERMISSION)),
    CLIENT(Set.of(Permission.CLIENT_PERMISSION));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toSet());
    }
}
