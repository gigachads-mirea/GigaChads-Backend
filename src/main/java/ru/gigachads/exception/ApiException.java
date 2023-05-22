package ru.gigachads.exception;

import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Описание класса
 */
public class ApiException extends ResponseStatusException {

    private final transient Object[] args;

    @Setter
    private String path;

    public ApiException(HttpStatus status, String reason, Object... args) {
        super(status, reason);
        this.args = args;
    }

    public ApiException(HttpStatus status, String reason, String path, Object... args) {
        super(status, reason);
        this.args = args;
        this.path = path;
    }

    protected Map<String, Object> getResponseBodyFields(MessageSource messageSource, Locale locale) {
        String message;
        try {
            message = messageSource.getMessage(Objects.requireNonNull(getReason()), args, locale);
        } catch (NoSuchMessageException e) {
            message = getReason();
        }
        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("timestamp", new Date());
        fields.put("status", getRawStatusCode());
        fields.put("error", message);
        fields.put("path", path);
        return fields;
    }

    public ResponseEntity<Map<String, Object>> toLocalResponseEntity(MessageSource messageSource, Locale locale) {
        return ResponseEntity
            .status(getStatus())
            .body(getResponseBodyFields(messageSource, locale));
    }

}
