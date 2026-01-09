package br.com.Portifolio.Medical.consultations.controller;

import br.com.Portifolio.Medical.consultations.dto.ExamDTO;
import br.com.Portifolio.Medical.consultations.model.*;
import br.com.Portifolio.Medical.consultations.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinic")
public class ExamController {

    @Autowired
    private ExamService service;

    @PostMapping("/exam/create")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam){
        Exam newExam = service.createExam(exam);
        return ResponseEntity.ok(newExam); // It will return 200(ok)
    }

    @GetMapping("/exam")
    public List<ExamDTO> obtainALlExams(){
        return service.obtainAllExams();
    }

    @GetMapping("/exam/{id}")
    public ResponseEntity<ExamDTO> obtainExamById(@PathVariable Long id){
        return service.obtainExamById(id)
                .map(e -> new ExamDTO(e.getReason(),e.getLocal(),e.getTime(),e.getExam_type(),e.getPatient(),
                        e.getDoctor(),e.getNurse(),e.getDate()))
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/exam/obtain/greather/{year}/{month}")
    public List<ExamDTO> examInAnYear(@PathVariable Long year, @PathVariable Long month){
        return service.examGreatherInAnYear(year, month);
    }

    @GetMapping("/exam/obtain/minor/{year}/{month}")
    public List<ExamDTO> examMinorInAYear(@PathVariable Long year, @PathVariable Long month){
        return service.examMinorInAYear(year, month);
    }

    @GetMapping("/exam/type/{type}")
    public List<ExamDTO> examByType(@PathVariable ExamType type){
        return service.examByType(type);
    }

    @PutMapping("/exam/{idExam}/doctor/{idDoctor}")
    public ResponseEntity<Optional<Doctor>> setDoctorToExam(@PathVariable Long idExam,@PathVariable Long idDoctor){
        service.setDoctorToExam(idExam,idDoctor);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/exam/{idExam}/patient/{idPatient}")
    public ResponseEntity<Optional<Patient>> setPatientToExam(@PathVariable Long idExam, @PathVariable Long idPatient){
        service.setPatientToExam(idExam, idPatient);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/exam/{idExam}/nurse/{idNurse}")
    public ResponseEntity<Optional<Nurse>> setNurseToExam(@PathVariable Long idExam, @PathVariable Long idNurse){
        service.setNurseToExam(idExam, idNurse);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/exam/{id}/date")
    public ResponseEntity<Exam> changeDate(@PathVariable Long id,@RequestBody Exam exam){
        service.changeDate(id, exam);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/exam/{id}/time")
    public ResponseEntity<Exam> changeTime(@PathVariable Long id,@RequestBody Exam exam){
        service.changeTime(id, exam);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/exam/{id}/delete")
    public ResponseEntity<Optional<Exam>> deleteExam(@PathVariable Long id){
        service.deleteExam(id);
        return ResponseEntity.ok().build();
    }
}
