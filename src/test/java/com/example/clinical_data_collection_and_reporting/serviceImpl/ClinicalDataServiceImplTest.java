package com.example.clinical_data_collection_and_reporting.serviceImpl;

import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.repository.ClinicalDataRepository;
import com.example.clinical_data_collection_and_reporting.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ClinicalDataServiceImplTest {

    @Mock
    ClinicalDataRepository clinicalDataRepository;
    @Mock
    PatientRepository patientRepository;
    @InjectMocks
    ClinicalDataServiceImpl clinicalDataService;

    @Test
    void saveData() {
        Patient patient = new Patient()
    }
}