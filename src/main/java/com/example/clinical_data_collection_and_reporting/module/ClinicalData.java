package com.example.clinical_data_collection_and_reporting.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="clinicaldata")
//@JsonIgnoreProperties({"patient"})
public class ClinicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Long patient_id;
    @NotNull
    private String componentName;
    @NotNull
    private String componentValue;


    private Timestamp measuredDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_id", nullable = false, referencedColumnName = "Id")
    @JsonIgnore
    private Patient patient;



}
