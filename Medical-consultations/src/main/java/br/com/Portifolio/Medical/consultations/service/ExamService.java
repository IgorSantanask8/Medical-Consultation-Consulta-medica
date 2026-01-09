package br.com.Portifolio.Medical.consultations.service;

import br.com.Portifolio.Medical.consultations.dto.ExamDTO;
import br.com.Portifolio.Medical.consultations.exception.IdNotFoundException;
import br.com.Portifolio.Medical.consultations.model.Doctor;
import br.com.Portifolio.Medical.consultations.model.Exam;
import br.com.Portifolio.Medical.consultations.model.Nurse;
import br.com.Portifolio.Medical.consultations.model.Patient;
import br.com.Portifolio.Medical.consultations.repository.DoctorRepository;
import br.com.Portifolio.Medical.consultations.repository.ExamRepository;
import br.com.Portifolio.Medical.consultations.repository.NurseRepository;
import br.com.Portifolio.Medical.consultations.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {

    @Autowired
    private ExamRepository repository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private NurseRepository nurseRepository;

    public List<ExamDTO> convert(List<Exam> exams){
        return exams.stream()
                .map(e -> new ExamDTO(e.getReason(),e.getLocal(),e.getTime(),
                        e.getExam_type(),e.getPatient(),e.getDoctor(),e.getNurse(),e.getDate()))
                .collect(Collectors.toList()); //Method created for convert one objetc of type Exam on ExamDTO
    }

    public Exam createExam(Exam exam) {
        return repository.save(exam);
    }

    public List<ExamDTO> obtainAllExams() {
        return convert(repository.findAll());
    }

    public void setDoctorToExam(Long idExam, Long idDoctor) {
        if(!doctorRepository.existsById(idDoctor) && !repository.existsById(idExam)){
            throw new RuntimeException("Id not found");
        }else if(doctorRepository.existsById(idDoctor) && repository.existsById(idExam)){
            Doctor doctorExam = doctorRepository.getReferenceById(idDoctor);
            repository.UpdateDoctor(idExam, doctorExam);//Method made using Query on ExamRepository class
            }
        }


    public void setPatientToExam(Long idExam, Long idpatient) {
        if(!repository.existsById(idExam) || !patientRepository.existsById(idpatient)){
            throw new IdNotFoundException("Id not found");
        }else if(repository.existsById(idExam) && patientRepository.existsById(idpatient)){
            Patient patientExam = patientRepository.getReferenceById(idpatient);
            repository.UpdatePatient(idExam, patientExam);//Method make using Query on ExamRepository class
        }
    }

    public void setNurseToExam(Long idExam, Long idNurse) {
        if(!repository.existsById(idExam) && nurseRepository.existsById(idNurse)){
            throw new RuntimeException("Id not found");
        }else if(repository.existsById(idExam) && nurseRepository.existsById(idNurse)){
            Nurse nurseExam = nurseRepository.getReferenceById(idNurse);
            repository.UpdateNurse(idExam,nurseExam);
        }
    }

    public Optional<Exam> obtainExamById(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        return repository.findById(id);
    }

    public Exam changeDate(Long id, Exam exam) {
        if(!repository.existsById(id)){
            throw new RuntimeException("id not found");
        }
        Exam examDatePostman = repository.getReferenceById(id);
        if(exam.getDate()!= null){
            examDatePostman.setDate(exam.getDate());
        }
        return repository.save(examDatePostman);
    }

    public Exam changeTime(Long id, Exam exam) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        Exam examTime = repository.getReferenceById(id);
        if(exam.getTime()!=null){
            examTime.setTime(exam.getTime());
        }
        return repository.save(examTime);
    }
}


