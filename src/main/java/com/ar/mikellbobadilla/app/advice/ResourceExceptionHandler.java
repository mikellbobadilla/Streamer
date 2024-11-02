package com.ar.mikellbobadilla.app.advice;

import com.ar.mikellbobadilla.app.exceptions.ResourceException;
import com.ar.mikellbobadilla.app.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ResourceExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoResourceFoundException.class)
    ErrorResponse notFoundPageHandler(NoResourceFoundException exc) {
        log.warn(exc.getMessage());
        return new ErrorResponse(NOT_FOUND.value(), "Not Found");
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exc) {
        log.warn(exc.getMessage());
        Map<String, String> errors = new HashMap<>();
        exc.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ResourceException.class)
    ErrorResponse resourceExceptionHandler(ResourceException exc) {
        log.warn(exc.getMessage());
        return new ErrorResponse(BAD_REQUEST.value(), exc.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    ErrorResponse resourceNotFoundExceptionHandler(ResourceNotFoundException exc) {
        log.warn(exc.getMessage());
        return new ErrorResponse(NOT_FOUND.value(), exc.getMessage());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    ErrorResponse systemExceptionHandler(RuntimeException exc) {
        log.error(exc.getMessage());
        return new ErrorResponse(INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
    }
}
