package com.premit.patient_registry.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    @NotBlank(message = "Name should not be empty.")
    @Size(min = 3,max = 50, message = "Name should be in between 3 and 50 chars.")
    private String patientName;

    @NotNull(message = "Age should not be empty.")
    @Min(value = 0 ,message = "Age must be 0 or greater than 0.")
    private int age;

    @NotBlank(message = "Sex should not be empty.")
    private String sex;

    @NotBlank(message = "Address should not be empty.")
    private String address;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Date should not be empty.")
    private LocalDate date;

   @Pattern(regexp = "^[6-9]\\d{9}$",message = "Invalid mobile number.")
   @NotBlank(message = "Mobile number should not be empty.")
   private String mobile;
}
