package br.com.Portifolio.Medical.consultations.controller;

import br.com.Portifolio.Medical.consultations.dto.PatientDTO;
import br.com.Portifolio.Medical.consultations.model.Patient;
import br.com.Portifolio.Medical.consultations.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinic")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("/patient/create")
    public ResponseEntity<Patient> creatPatient(@RequestBody Patient patient){
        Patient newPatient = service.createPatient(patient);
        return ResponseEntity.ok(newPatient);
    }

    @GetMapping("/patient")
    public List<PatientDTO> obtainAllPatient(){
        return service.obtainAllPatient();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> obtainPatientByiId(@PathVariable Long id){
        return service.obtainPatientById(id)
                .map(p -> new PatientDTO(p.getName(),p.getCpf(),p.getPhone(),p.getEmail(),
                        p.getDateOfBirth(),p.getAge()))
                .map(dto -> ResponseEntity.ok().body(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/patient/delete/{id}")
    public ResponseEntity<Optional<Patient>> deletePatientById(@PathVariable Long id){
        service.deletePatientById(id);
        return ResponseEntity.noContent().build();//it will return no content
    }

    @PutMapping("/patient/{id}/change/email")
    public ResponseEntity<Patient> changeEmail(@PathVariable Long id, @RequestBody Patient patient){
        service.changePatientEmail(id, patient);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/patient/{id}/change/phone")
    public ResponseEntity<Patient> changePhone(@PathVariable Long id, @RequestBody Patient patient){
        service.changePatientPhone(id, patient);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/patient/{id}/change/age")
    public ResponseEntity<Patient> changeAge(@PathVariable Long id, @RequestBody Patient patient){
        service.changeAge(id,patient);
        return ResponseEntity.ok().build();
    }
}
