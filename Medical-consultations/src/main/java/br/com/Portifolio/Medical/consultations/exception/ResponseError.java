package br.com.Portifolio.Medical.consultations.exception;

import org.springframework.http.HttpStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseError(String mensagem, HttpStatus httpStatus, LocalDateTime now) {
}
