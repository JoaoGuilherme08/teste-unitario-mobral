package com.solinftec.testeunitario.exceptions;

import com.solinftec.testeunitario.exceptions.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@RestControllerAdvice
public class TesteExceptionHandler {

    @ExceptionHandler(LoginValidationException.class)
    public ResponseEntity<ExceptionResponse> handleValidationLogin(LoginValidationException ex, HttpServletRequest request) {
        var errorResponse = ExceptionResponse.builder()
                .timestamp(OffsetDateTime.now().toString())
                .error("Login validation")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
