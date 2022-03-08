package com.example.clinical_data_collection_and_reporting.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientResponse {

    private String firstName;
    private String lastName;
    private int age;
}
