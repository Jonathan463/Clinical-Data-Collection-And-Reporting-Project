package com.example.clinical_data_collection_and_reporting.dto;

import com.example.clinical_data_collection_and_reporting.module.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicalResponse {

    private String componentName;

    private String componentValue;

    private Timestamp measuredDateTime;

    private PatientResponse patient;
}
