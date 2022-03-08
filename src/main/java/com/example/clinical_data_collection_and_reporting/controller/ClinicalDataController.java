package com.example.clinical_data_collection_and_reporting.controller;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.dto.ClinicalResponse;
import com.example.clinical_data_collection_and_reporting.dto.PatientResponse;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.repository.ClinicalDataRepository;
import com.example.clinical_data_collection_and_reporting.service.ClinicalDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class ClinicalDataController {

    private final ClinicalDataService clinicalDataService;

    public ClinicalDataController(ClinicalDataService clinicalDataService) {
        this.clinicalDataService = clinicalDataService;
    }

    @PostMapping("/clinicals")
    public ClinicalResponse saveClinicalData(@RequestBody ClinicalDataRequest request){
//
//        PatientResponse patientResponse = new PatientResponse();
//        //ClinicalData clinicalData = clinicalDataService.saveData(request);
//        //log.info("Clinical Data: {}", clinicalData);
//        ClinicalData clinicalData = new ClinicalData();
//        ClinicalResponse clinicalResponse = new ClinicalResponse();
//        clinicalResponse.setComponentName(clinicalData.getComponentName());
//        clinicalResponse.setComponentValue(clinicalData.getComponentValue());
//        clinicalResponse.setMeasuredDateTime(clinicalData.getMeasuredDateTime());
//        clinicalResponse.setPatient(patientResponse);
        return clinicalDataService.saveData(request);
    }
}
