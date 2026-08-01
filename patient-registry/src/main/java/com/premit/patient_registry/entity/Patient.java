package com.premit.patient_registry.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name="patient_dtls")
public class Patient {

    @Id
    @Column(name="id")
    private int patientId;

    @Column(name="pt_name")
    private String patientName;

    @Column(name="age")
    private int age;

    @Column(name="sex")
    private String sex;

    @Column(name="address")
    private String address;

    @Column(name="visit_date")
    private LocalDate date;

    @Column(name="mobile")
    private String mobile;
}
