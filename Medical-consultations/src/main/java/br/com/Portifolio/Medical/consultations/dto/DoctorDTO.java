package br.com.Portifolio.Medical.consultations.dto;

import br.com.Portifolio.Medical.consultations.model.DoctorSpecialty;

public record DoctorDTO(String name, String crm,
                        DoctorSpecialty specialty, String phone,
                        String email) {
}
