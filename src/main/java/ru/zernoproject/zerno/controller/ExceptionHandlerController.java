package ru.zernoproject.zerno.controller;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.zernoproject.zerno.exception.ApplicationEx;

import java.util.Map;
import java.util.NoSuchElementException;

import static ru.zernoproject.zerno.utils.Constants.*;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = PSQLException.class)
    public ResponseEntity<Object> handlePsqlException(final PSQLException ex, final WebRequest request) {
        return handleExceptionInternal(
                ex,
                makeErrorResponse(ex, HttpStatus.BAD_GATEWAY),
                new HttpHeaders(),
                HttpStatus.BAD_GATEWAY,
                request
        );
    }

    @ExceptionHandler(value = ApplicationEx.class)
    public ResponseEntity<Object> handleApplicationException(final RuntimeException ex, final WebRequest request) {
        return handleExceptionInternal(
                ex,
                makeErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    //500
    @ExceptionHandler(value = {NullPointerException.class, JpaSystemException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleInternalError(final RuntimeException ex, final WebRequest request) {
        return handleExceptionInternal(
                ex,
                makeErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    //404
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> handleNotFoundException(final RuntimeException ex, final WebRequest request) {
        return handleExceptionInternal(
                ex,
                makeErrorResponse(ex, HttpStatus.NOT_FOUND),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }

    private static Map<String, Object> makeErrorResponse(Exception ex, HttpStatus httpStatus) {
        return Map.of(
                SERVICE_NAME_FIELD, SERVICE_NAME,
                ERROR_CODE_FIELD, httpStatus,
                USER_MESSAGE_FIELD, httpStatus.getReasonPhrase(),
                DEVELOPER_MESSAGE_FIELD, ex.getMessage()
        );
    }

}
