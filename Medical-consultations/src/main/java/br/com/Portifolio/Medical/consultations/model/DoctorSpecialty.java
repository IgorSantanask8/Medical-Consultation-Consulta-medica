package br.com.Portifolio.Medical.consultations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DoctorSpecialty {
    @JsonProperty("routine")
    ROUTINE,
    @JsonProperty("orthopedic")
    ORTHOPEDIC,
    @JsonProperty("cardiologist")
    CARDIOLOGIST,
    @JsonProperty("pulmonologist")
    PULMONOLOGIST,
    @JsonProperty("physiotherapist")
    PHYSIOTHERAPIST,
    @JsonProperty("gynecologist")
    GYNECOLOGIST,
    @JsonProperty("pediatric, Pediatric")
    PEDIATRIC,
    DEAFULT
}
