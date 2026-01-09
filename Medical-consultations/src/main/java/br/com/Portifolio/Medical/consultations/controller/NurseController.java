package br.com.Portifolio.Medical.consultations.controller;

import br.com.Portifolio.Medical.consultations.dto.NurseDto;
import br.com.Portifolio.Medical.consultations.model.Nurse;
import br.com.Portifolio.Medical.consultations.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinic")
public class NurseController {

    @Autowired
    private NurseService service;

    @PostMapping("/nurse/create")
    public ResponseEntity<Nurse> createNurse(@RequestBody  Nurse nurse){
        Nurse newNurse = service.createNurse(nurse);
        return ResponseEntity.ok(newNurse); // it will return 200(ok)
    }

    @DeleteMapping("/nurse/delete/{id}")
    public ResponseEntity<Optional<Nurse>> deleteNurse(@PathVariable Long id){
        service.deleteNurse(id);
        return ResponseEntity.noContent().build(); //it will return 204(not found)
    }

    @GetMapping("/nurse/{id}")
    public ResponseEntity<NurseDto> getNurseById(@PathVariable Long id){
        return service.obtainNurseById(id)
                .map(n -> new NurseDto(n.getName(),n.getCoren(),n.getEmail(), n.getPhone()))
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nurse")
    public List<NurseDto> obtainAllNurses(){
        return service.obtainAllNurses();
    }

    @PutMapping("/nurse/{id}/change/email")
    public ResponseEntity<Nurse> changeEmail(@PathVariable Long id, @RequestBody Nurse nurse){
        service.changeNurseEmail(id, nurse);
        return ResponseEntity.ok().build();
    }


}
