package br.com.Portifolio.Medical.consultations.service;

import br.com.Portifolio.Medical.consultations.dto.NurseDto;
import br.com.Portifolio.Medical.consultations.exception.IdNotFoundException;
import br.com.Portifolio.Medical.consultations.model.Nurse;
import br.com.Portifolio.Medical.consultations.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NurseService {

    @Autowired
    private NurseRepository repository;

    public List<NurseDto> convert(List<Nurse> nurses){
       return nurses.stream()
                .map(n -> new NurseDto(n.getName(),n.getCoren(),n.getEmail(),
                        n.getPhone()))
                .collect(Collectors.toList());
    }


    public Nurse createNurse(Nurse nurse) {
        return repository.save(nurse);
    }

    public void deleteNurse(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        repository.deleteById(id);
    }

    public List<NurseDto> obtainAllNurses() {
        return convert(repository.findAll());
    }

    public Optional<Nurse>  obtainNurseById(Long id) {

        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        return repository.findById(id);
    }

    public Nurse changeNurseEmail(Long id, Nurse nurse) {
        if(!repository.existsById(id)){
            throw new IdNotFoundException("Id not found");
        }
        Nurse nurseChangeEmail = repository.getReferenceById(id);
        if(nurse.getEmail()!= null){
            nurseChangeEmail.setEmail(nurse.getEmail());
        }
        return repository.save(nurseChangeEmail);
    }

    public Nurse changePhone(Long id, Nurse nurse) {
        if(!repository.existsById(id)){
            throw new IdNotFoundException("Id not found");
        }
        Nurse nurseEmail = repository.getReferenceById(id);
        if(nurse.getPhone()!= null){
            nurseEmail.setPhone(nurse.getPhone());
        }
        return repository.save(nurseEmail);
    }
}
