package br.com.Portifolio.Medical.consultations.repository;

import br.com.Portifolio.Medical.consultations.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
