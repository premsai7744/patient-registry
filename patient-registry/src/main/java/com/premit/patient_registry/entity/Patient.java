package com.premit.patient_registry.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name="patient_dtls")
public class Patient {

    @SequenceGenerator(name="patient_id_gen",
    sequenceName = "patient_register_seq",
    allocationSize = 1)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patient_id_gen")
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
