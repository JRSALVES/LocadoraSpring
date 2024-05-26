package com.jrs.LocadoraSpring.controller.advice;

import com.jrs.LocadoraSpring.entity.json.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import com.jrs.LocadoraSpring.exception.AbtractMinhaException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@RestController
@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AbtractMinhaException.class)
    public ResponseEntity<ExceptionResponse> handleAbstractMinhaException(AbtractMinhaException ex, HttpServletRequest request)
            throws IOException {
        return ResponseEntity.internalServerError().body(new ExceptionResponse(ex, request.getRequestURI()));

    }
}
