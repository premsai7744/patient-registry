package com.premit.patient_registry.service;

import com.premit.patient_registry.dto.PatientDTO;
import com.premit.patient_registry.entity.Patient;
import com.premit.patient_registry.mapper.PatientMapper;
import com.premit.patient_registry.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{



    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PatientRepository patientRepository;

    Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Override
    public ResponseEntity<String> registerPatientDetails(PatientDTO patientDTO) {
        logger.info("request received to service : "+patientDTO);
        Patient patient = patientMapper.toEntity(patientDTO);
        logger.info("Patient entity : "+patient);
        Patient savedEntity = patientRepository.save(patient);
        if(savedEntity!=null){
            return new ResponseEntity<>("Patient registered successfully.",HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Patient registration failed.",HttpStatus.OK);
        }
    }
}
