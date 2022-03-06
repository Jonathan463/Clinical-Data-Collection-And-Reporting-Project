package com.example.clinical_data_collection_and_reporting.service;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;

public interface ClinicalDataService {
    ClinicalData saveData(ClinicalDataRequest request);
}
