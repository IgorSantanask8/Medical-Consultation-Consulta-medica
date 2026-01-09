package br.com.Portifolio.Medical.consultations.repository;

import br.com.Portifolio.Medical.consultations.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
