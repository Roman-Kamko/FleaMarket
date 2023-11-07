package com.team2.flea_market.handler;

import com.team2.flea_market.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({
            AdNotFoundException.class,
            CommentNotFoundException.class,
            ImageNotFoundException.class,
            UserNotFoundException.class
    })
    public ResponseEntity<?> handleNotFound(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler({
            PasswordChangeException.class,
            UserAlreadyRegisterException.class
    })
    public ResponseEntity<?> handleConflict(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(EntityConversionException.class)
    public ResponseEntity<?> handleBadRequest(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

}
