package com.example.clinical_data_collection_and_reporting.controller;

import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value="/patients", method = RequestMethod.GET)
    public List<Patient> getAllPatient(){
        return patientService.findAll();
    }
    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id){
        return patientService.getPatientById(id);
    }
}
