package com.example.clinical_data_collection_and_reporting.controller;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.repository.ClinicalDataRepository;
import com.example.clinical_data_collection_and_reporting.service.ClinicalDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

    private ClinicalDataService clinicalDataService;

    public ClinicalDataController(ClinicalDataService clinicalDataService) {
        this.clinicalDataService = clinicalDataService;
    }

    @PostMapping("/clinicals")
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request){
        return clinicalDataService.saveData(request);
    }
}
