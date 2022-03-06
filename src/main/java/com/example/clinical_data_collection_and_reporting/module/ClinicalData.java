package com.example.clinical_data_collection_and_reporting.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long patient_id;
    private String component_name;
    private String component_value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date measured_date_time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_id", referencedColumnName = "Id")
    private Patient patient;

}
