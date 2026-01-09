package br.com.Portifolio.Medical.consultations.dto;

import java.time.LocalDate;

public record PatientDTO(String name,
                         String cpf,
                         String phone,
                         String email,
                         LocalDate dateOfBirth,
                         Integer age) {
}
