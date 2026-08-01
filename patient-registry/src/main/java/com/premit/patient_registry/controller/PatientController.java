package com.premit.patient_registry.controller;

import com.premit.patient_registry.dto.PatientDTO;
import com.premit.patient_registry.service.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    @PostMapping(path="/register")
    public ResponseEntity<String> registerPatientDetails(@Valid @RequestBody PatientDTO patientDTO) {
        logger.info("Request received to controller: "+patientDTO);
        ResponseEntity<String> resposne = patientService.registerPatientDetails(patientDTO);
        return resposne;
    }
}
