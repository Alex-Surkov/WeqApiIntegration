package com.github.Alex_Surkov.weqapiintegration.exceptionhandler;

import com.github.Alex_Surkov.weqapiintegration.dto.ErrorDto;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    ResponseEntity<ErrorDto> handleFeignCatNotFound(FeignException.NotFound exception, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(
                "Cat not found in API",
                "404",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(CatApiUnauthorizedException.class)
    ResponseEntity<ErrorDto> handleCatApiUnauthorizedException(CatApiUnauthorizedException exception, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(
                exception.getMessage(),
                "CAT_API_UNAUTHORIZED",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    ResponseEntity<ErrorDto> handleNoHandlerFound(NoHandlerFoundException exception, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(
                "No handler found in API",
                "CAT_API_NO_HANDLER",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<ErrorDto> handleBadRequest(MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(
                "Invalid argument" + exception.getName(),
                "CAT_API_BAD_REQUEST",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorDto> handleGeneric(Exception exception, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(
                exception.getMessage(),
                "INTERNAL_SERVER_ERROR",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }
}
