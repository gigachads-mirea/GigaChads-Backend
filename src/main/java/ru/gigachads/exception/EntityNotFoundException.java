package ru.gigachads.exception;

import org.springframework.http.HttpStatus;

/**
 * Описание класса
 */
public class EntityNotFoundException extends ApiException {

    public EntityNotFoundException(Object entity) {
        super(HttpStatus.NOT_FOUND, "entityNotFound", entity);
    }

}
