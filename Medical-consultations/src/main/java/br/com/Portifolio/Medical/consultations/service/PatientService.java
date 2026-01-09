package br.com.Portifolio.Medical.consultations.service;

import br.com.Portifolio.Medical.consultations.dto.PatientDTO;
import br.com.Portifolio.Medical.consultations.exception.IdNotFoundException;
import br.com.Portifolio.Medical.consultations.model.Patient;
import br.com.Portifolio.Medical.consultations.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;


    public List<PatientDTO> convert(List<Patient> patients){
        return patients.stream()
                .map(p -> new PatientDTO(p.getName(),p.getCpf(),p.getPhone(),p.getEmail(),
                        p.getDateOfBirth()))
                .collect(Collectors.toList());
    }

    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    public List<PatientDTO> obtainAllPatient() {
        return convert(repository.findAll());
    }

    public Optional<Patient> obtainPatientById(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        return repository.findById(id);
    }

    public void deletePatientById(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        repository.deleteById(id);
    }

    public Patient changePatientEmail(Long id, Patient patient) {
        if(!repository.existsById(id)){
            throw new IdNotFoundException("Id not found");
        }
        Patient patientEmail = repository.getReferenceById(id);
        if(patient.getEmail()!=null){
            patientEmail.setEmail(patient.getEmail());
        }
        return repository.save(patientEmail);
    }
}
