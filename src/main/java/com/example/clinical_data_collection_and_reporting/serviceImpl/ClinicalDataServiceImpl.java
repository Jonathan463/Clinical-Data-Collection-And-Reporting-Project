package com.example.clinical_data_collection_and_reporting.serviceImpl;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.dto.ClinicalResponse;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.repository.ClinicalDataRepository;
import com.example.clinical_data_collection_and_reporting.repository.PatientRepository;
import com.example.clinical_data_collection_and_reporting.service.ClinicalDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalDataServiceImpl implements ClinicalDataService {
    private final PatientRepository patientRepository;
    private final ClinicalDataRepository clinicalDataRepository;
    private final ModelMapper modelMapper;

//    @Autowired
    public ClinicalDataServiceImpl(PatientRepository patientRepository, ClinicalDataRepository clinicalDataRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.clinicalDataRepository = clinicalDataRepository;
        this.modelMapper =  modelMapper;
    }

    @Override
    public ClinicalResponse saveData(ClinicalDataRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(
                () -> {
                    throw new NullPointerException("something");
                }
        );
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);
        clinicalDataRepository.save(clinicalData);
        return modelMapper.map(clinicalData, ClinicalResponse.class);
    }




}
