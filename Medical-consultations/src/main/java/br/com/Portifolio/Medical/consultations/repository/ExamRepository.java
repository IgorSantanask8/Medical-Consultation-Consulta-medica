package br.com.Portifolio.Medical.consultations.repository;

import br.com.Portifolio.Medical.consultations.model.Doctor;
import br.com.Portifolio.Medical.consultations.model.Exam;
import br.com.Portifolio.Medical.consultations.model.Nurse;
import br.com.Portifolio.Medical.consultations.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Exam e SET e.doctor = :doctor WHERE e.id = :examId")
    void UpdateDoctor(@Param("examId") Long examId, @Param("doctor") Doctor doctor);

    @Modifying
    @Transactional
    @Query("Update Exam e SET e.patient = :patient WHERE e.id = :examId")
    void UpdatePatient(@Param("examId") Long examId, @Param("patient") Patient patient);

    @Modifying
    @Transactional
    @Query("UPDATE Exam e SET e.nurse = :nurse WHERE e.id = :examId")
    void UpdateNurse(@Param("examId") Long examId, @Param("nurse") Nurse nurse);

    @Modifying
    @Transactional
    @Query("UPDATE Exam e SET e.date = :date WHERE e.id = :examId")
    void UpdateDate(@Param("examID") Long examId, @Param("date")LocalDate date);
}
