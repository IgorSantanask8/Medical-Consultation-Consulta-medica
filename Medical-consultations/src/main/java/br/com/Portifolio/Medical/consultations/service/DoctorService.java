package br.com.Portifolio.Medical.consultations.service;

import br.com.Portifolio.Medical.consultations.dto.DoctorDTO;
import br.com.Portifolio.Medical.consultations.exception.IdNotFoundException;
import br.com.Portifolio.Medical.consultations.model.Doctor;
import br.com.Portifolio.Medical.consultations.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository repository;

    public List<DoctorDTO> convert(List<Doctor> doctorList){
        return doctorList.stream()
                .map(d -> new DoctorDTO(d.getName(),d.getCrm(),d.getSpecialty(),
                        d.getPhone(),d.getEmail()))
                .collect(Collectors.toList());
    }

    public List<DoctorDTO> obtainAllDoctors(){
        return convert(repository.findAll());
    }

    public Doctor createDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public void excluirId(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id Not found");
        }
        repository.deleteById(id);
    }

    public Optional<Doctor> obtainDoctorById(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Id not found");
        }
        return repository.findById(id);
    }

    public Doctor changeEmail(Long id, Doctor doctor) {
        if(!repository.existsById(id)){
            throw new IdNotFoundException("Id not found");
        }
        Doctor doctorChangeEmail = repository.getReferenceById(id);
        if(doctor.getEmail()!=null){
            doctorChangeEmail.setEmail(doctor.getEmail());
        }
        return repository.save(doctorChangeEmail);
    }

    public Doctor changePhoneDoctor(Long id, Doctor doctor) {
        if(!repository.existsById(id)){
            throw new IdNotFoundException("Id not found");
        }
        Doctor doctorPhone = repository.getReferenceById(id);
        if(doctor.getPhone()!=null){
            doctorPhone.setPhone(doctor.getPhone());
        }
        return repository.save(doctorPhone);
    }
}
