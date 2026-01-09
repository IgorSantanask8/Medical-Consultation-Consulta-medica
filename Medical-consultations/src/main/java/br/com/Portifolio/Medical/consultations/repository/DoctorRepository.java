package br.com.Portifolio.Medical.consultations.repository;

import br.com.Portifolio.Medical.consultations.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByCrm(String crm);

}
