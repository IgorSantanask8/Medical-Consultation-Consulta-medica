package br.com.Portifolio.Medical.consultations.controller;

import br.com.Portifolio.Medical.consultations.dto.DoctorDTO;
import br.com.Portifolio.Medical.consultations.model.Doctor;
import br.com.Portifolio.Medical.consultations.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinic")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping("/doctor")
    public List<DoctorDTO> obtainALlDoctors (){
        return service.obtainAllDoctors();//It will show 200(ok)
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<DoctorDTO> obtainDoctorById(@PathVariable Long id){
        return  service.obtainDoctorById(id)
                .map(d-> new DoctorDTO(d.getName(),d.getCrm(),d.getSpecialty(),d.getPhone()
                ,d.getEmail()))
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/doctor/create")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        Doctor newDoctor = service.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
    }

    @DeleteMapping("/doctor/delete/{id}")
    public ResponseEntity<Optional<Doctor>> deleteDoctor(@PathVariable Long id){
        service.excluirId(id);
        return ResponseEntity.noContent().build();//It will show 204(No content)
    }

    @PutMapping("/doctor/{id}/change/email")
    public ResponseEntity<Doctor> changeEmail(@PathVariable Long id, @RequestBody Doctor doctor){
        service.changeEmail(id, doctor);
        return ResponseEntity.ok().build();
    }
}
