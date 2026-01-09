package br.com.Portifolio.Medical.consultations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseError> idException(IdNotFoundException e){

        ResponseError error = new ResponseError(
            e.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
