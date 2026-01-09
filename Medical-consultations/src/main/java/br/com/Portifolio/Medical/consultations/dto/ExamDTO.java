package br.com.Portifolio.Medical.consultations.dto;

import br.com.Portifolio.Medical.consultations.model.*;

import java.time.LocalDate;

public record ExamDTO(String reason,
                      Local local,
                      String time,
                      ExamType exam_type,
                      Patient patient,
                      Doctor doctor,
                      Nurse nurse,
                      LocalDate date) {
}
