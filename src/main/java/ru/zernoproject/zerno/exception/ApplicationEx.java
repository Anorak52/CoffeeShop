package ru.zernoproject.zerno.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ApplicationEx extends Throwable{
    private final String serviceName;
    private final HttpStatus errorCode;
    private final String userMessage;
    private final String developerMessage;
}
