package com.example.clinical_data_collection_and_reporting.serviceImpl;

import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.repository.PatientRepository;
import com.example.clinical_data_collection_and_reporting.service.PatientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;


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
}
