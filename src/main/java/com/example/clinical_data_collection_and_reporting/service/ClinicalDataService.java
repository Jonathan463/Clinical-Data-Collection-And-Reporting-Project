package com.example.clinical_data_collection_and_reporting.service;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.dto.ClinicalResponse;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import org.springframework.stereotype.Service;

@Service
public interface ClinicalDataService {
    ClinicalResponse saveData(ClinicalDataRequest request);

}
