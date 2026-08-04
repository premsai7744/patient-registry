package com.premit.patient_registry.mapper;

import com.premit.patient_registry.dto.PatientDTO;
import com.premit.patient_registry.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDTO toDTO(Patient patient);
    @Mapping(target = "patientId", ignore = true)
    Patient toEntity(PatientDTO patientDTO);
}
