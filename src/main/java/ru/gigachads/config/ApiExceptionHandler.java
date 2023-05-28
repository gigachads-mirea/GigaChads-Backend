package ru.gigachads.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.gigachads.exception.ApiException;
import ru.gigachads.exception.TokenRefreshException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Описание класса
 */
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler({
        HttpMessageNotReadableException.class,
        MethodArgumentTypeMismatchException.class,
        MethodArgumentNotValidException.class,
        MissingServletRequestParameterException.class,
        MissingPathVariableException.class,
        ConstraintViolationException.class
    })
    public ResponseEntity<Map<String, Object>> handleJsonException(Exception exception, Locale locale,
                                                                   HttpServletRequest request) {
        ApiException wrapper = new ApiException(HttpStatus.BAD_REQUEST, "Bad request", extractQueryPath(request));
        log.error(exception.getMessage(), exception);
        return wrapper.toLocalResponseEntity(messageSource, locale);
    }

    @ExceptionHandler(TokenRefreshException.class)
    public ResponseEntity<Map<String, Object>> handleForbiddenException(
        EmptyResultDataAccessException exception, Locale locale, HttpServletRequest request) {
        ApiException wrapper = new ApiException(HttpStatus.FORBIDDEN, "This operation is forbidden", extractQueryPath(request));
        log.error(exception.getMessage(), exception);
        return wrapper.toLocalResponseEntity(messageSource, locale);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyResultDataAccessException(
        EmptyResultDataAccessException exception, Locale locale, HttpServletRequest request) {
        ApiException wrapper = new ApiException(HttpStatus.NOT_FOUND, "Entity not found", extractQueryPath(request));
        log.error(exception.getMessage(), exception);
        return wrapper.toLocalResponseEntity(messageSource, locale);
    }

    private String extractQueryPath(HttpServletRequest request) {
        return Objects.nonNull(request.getQueryString())
            ? String.format("%s?%s", request.getRequestURI(), request.getQueryString())
            : request.getRequestURI();
    }
}
