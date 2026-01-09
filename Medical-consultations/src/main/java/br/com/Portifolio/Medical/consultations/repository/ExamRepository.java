package br.com.Portifolio.Medical.consultations.repository;

import br.com.Portifolio.Medical.consultations.model.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

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
    @Query("UPDATE Exam e SET e.time = :time WHERE e.id = :examId")
    LocalDate UpdateTime(@Param("time") String time, @Param("examId") Long examId);

    @Query("SELECT e FROM Exam e WHERE  YEAR(e.date) >= :ano AND MONTH(e.date) >= :mes")
    List<Exam> examsGreatherInYear(@Param("ano")Long ano, @Param("mes")Long mes);

    @Query("SELECT e FROM Exam e WHERE YEAR(e.date) <= :year AND MONTH(e.date) <= :month")
    List<Exam> examsMinorInYear(@Param("year") Long year, @Param("month") Long month);

    @Query("SELECT e FROM Exam e WHERE e.exam_type = :type")
    List<Exam> examsByType(@Param("type") ExamType type);

}
