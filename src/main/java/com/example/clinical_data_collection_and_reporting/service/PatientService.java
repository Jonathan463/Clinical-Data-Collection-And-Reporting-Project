package com.example.clinical_data_collection_and_reporting.service;

import com.example.clinical_data_collection_and_reporting.module.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PatientService {
    List<Patient> findAll();
}
