package ru.gigachads.entity;

/**
 * Описание класса
 */
public enum Permission {
    USERS_PERMISSION("users:permission"),
    ADMIN_PERMISSION("admin:permission"),
    CLIENT_PERMISSION("client:permission");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}