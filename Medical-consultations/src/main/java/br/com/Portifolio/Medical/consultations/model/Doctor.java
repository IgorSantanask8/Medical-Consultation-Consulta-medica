package br.com.Portifolio.Medical.consultations.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String crm;
    private String phone;
    private String email;

    @Enumerated(EnumType.STRING)
    private DoctorSpecialty specialty;

    @OneToMany
    private List<Patient> patientList;

    @OneToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Doctor(){}

    public Doctor(String name, String crm, DoctorSpecialty specialty, String phone,
                  String email){
        this.name = name;
        this.crm = crm;
        this.specialty = specialty;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public DoctorSpecialty getSpecialty() {
        return specialty;
    }
    public void setSpecialty(DoctorSpecialty specialty) {
        this.specialty = specialty;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
