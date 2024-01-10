package com.solinftec.testeunitario.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class LoginValidationException extends RuntimeException {
    private final String message;

    public LoginValidationException(String message) {
        super(message);
        this.message = message;
    }
}
