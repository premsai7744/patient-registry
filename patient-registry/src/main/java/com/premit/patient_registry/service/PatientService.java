package com.premit.patient_registry.service;

import com.premit.patient_registry.dto.PatientDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PatientService {

    ResponseEntity<String> registerPatientDetails(@Valid PatientDTO patientDTO);
}
