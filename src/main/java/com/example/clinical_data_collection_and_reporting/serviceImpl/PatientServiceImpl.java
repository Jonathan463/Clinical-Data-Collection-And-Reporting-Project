package com.example.clinical_data_collection_and_reporting.serviceImpl;

import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.repository.PatientRepository;
import com.example.clinical_data_collection_and_reporting.service.PatientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    Map<String, String> filters = new HashMap<>();

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.getById(id);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient analyzeData(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                ()-> {
                    throw new NullPointerException("Patient Not Fund");
                }
        );
        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
        for(ClinicalData eachData : duplicateClinicalData) {
            if (filters.containsKey(eachData.getComponentName())) {
                clinicalData.remove(eachData);
                continue;
            } else {
                filters.put(eachData.getComponentName(), null);
            }
            if (eachData.getComponentName().equals("hw")) {
                String[] heightAndWeight = eachData.getComponentValue().split("/");
                if (heightAndWeight.length > 1) {
                    float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                    float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
                    ClinicalData bmiData = new ClinicalData();
                    bmiData.setComponentName("bmi");
                    bmiData.setComponentValue(Float.toString(bmi));
                    clinicalData.add(bmiData);
                }
            }
        }
        filters.clear();
        return patient;
    }
}
