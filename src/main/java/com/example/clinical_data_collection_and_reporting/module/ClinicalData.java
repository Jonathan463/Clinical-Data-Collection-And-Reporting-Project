package com.example.clinical_data_collection_and_reporting.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="clinicaldata")
@JsonIgnoreProperties({"patient"})
public class ClinicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Long patient_id;
    private String componentName;
    private String componentValue;


    private Timestamp measuredDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable = false, referencedColumnName = "Id")
    private Patient patient;

}
