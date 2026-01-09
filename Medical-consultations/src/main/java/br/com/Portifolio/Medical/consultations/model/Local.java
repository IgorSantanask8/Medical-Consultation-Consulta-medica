package br.com.Portifolio.Medical.consultations.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Enumerated;

public enum Local {
    @JsonProperty("laboratory, Laboratory")
    LABORATORY,
    @JsonProperty("cardiology")
    CARDIOLOGY,
    @JsonProperty("orthopedics")
    ORTHOPEDICS,
    @JsonProperty("pulmonolgy")
    PULMONOLOGY,
    @JsonProperty("physiotherapy")
    PHYSIOTHERAPY,
    @JsonProperty("gynecology")
    GYNECOLOGY,
    @JsonProperty("pediatric")
    PEDIATRIC,
    DEFAULT
}
