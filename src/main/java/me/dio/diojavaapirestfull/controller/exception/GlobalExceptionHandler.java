package me.dio.diojavaapirestfull.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handler(IllegalArgumentException ex){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handler(NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource id not found!");
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handler(Throwable ex){
        String message = "Unexpected server error, see the logs";
        LOGGER.error(message, ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                "Unexpected server error, see the logs");
    }
}
