package com.example.clinical_data_collection_and_reporting.serviceImpl;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.repository.ClinicalDataRepository;
import com.example.clinical_data_collection_and_reporting.repository.PatientRepository;
import com.example.clinical_data_collection_and_reporting.service.ClinicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicalDataServiceImpl implements ClinicalDataService {
    private PatientRepository patientRepository;
    private ClinicalDataRepository clinicalDataRepository;

    @Autowired
    public ClinicalDataServiceImpl(PatientRepository patientRepository, ClinicalDataRepository clinicalDataRepository) {
        this.patientRepository = patientRepository;
        this.clinicalDataRepository = clinicalDataRepository;
    }

    @Override
    public ClinicalData saveData(ClinicalDataRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);
        return clinicalDataRepository.save(clinicalData);
    }
}
