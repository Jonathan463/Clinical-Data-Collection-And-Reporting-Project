package com.example.clinical_data_collection_and_reporting.serviceImpl;

import com.example.clinical_data_collection_and_reporting.dto.ClinicalDataRequest;
import com.example.clinical_data_collection_and_reporting.dto.ClinicalResponse;
import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import com.example.clinical_data_collection_and_reporting.module.Patient;
import com.example.clinical_data_collection_and_reporting.repository.ClinicalDataRepository;
import com.example.clinical_data_collection_and_reporting.repository.PatientRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClinicalDataServiceImplTest {

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    ClinicalDataRepository clinicalDataRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    ClinicalDataServiceImpl clinicalDataService ;
     private Patient patient;
    private ClinicalDataRequest dataRequest;
    private ClinicalData clinicalData;
    private static final String componentValue = "Test component value";
    private static final String componentName = "Test component name";


    @Before
   public void setup(){
        patient = new Patient();
//        patient.setId(1L);
        patient.setFirstName("Test Patient");
        dataRequest = new ClinicalDataRequest();
        dataRequest.setPatientId(patient.getId());
        dataRequest.setComponentValue(componentValue);
        dataRequest.setComponentName(componentName);
        clinicalData = new ClinicalData();
        clinicalData.setComponentValue(componentValue);
        clinicalData.setPatient(patient);
        clinicalDataService = new ClinicalDataServiceImpl(patientRepository,clinicalDataRepository,modelMapper);

    }

    @Test
   public void saveDataTest() {
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
//        when(clinicalDataRepository.save(clinicalData)).thenReturn(clinicalData);
        clinicalDataRepository.save(clinicalData);
        when(clinicalDataRepository.findById(clinicalData.getId())).thenReturn(Optional.of(clinicalData));
        var expected = clinicalDataService.saveData(dataRequest);
        verify(patientRepository,times(1)).findById(patient.getId());
        verify(clinicalDataRepository,times(1)).save(clinicalData);
        var actual  = modelMapper.map(clinicalData, ClinicalResponse.class);
//        assertEquals(expected.getPatient().getFirstName(),patient.getFirstName());
        assertEquals(actual,expected);


    }


}