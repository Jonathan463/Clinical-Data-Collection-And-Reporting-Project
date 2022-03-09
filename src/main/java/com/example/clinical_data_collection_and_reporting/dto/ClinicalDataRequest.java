package com.example.clinical_data_collection_and_reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicalDataRequest {
    private String ComponentName;
    private String componentValue;
    private Long patientId;
}
