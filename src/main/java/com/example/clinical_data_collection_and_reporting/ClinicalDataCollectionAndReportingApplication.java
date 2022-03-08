package com.example.clinical_data_collection_and_reporting;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClinicalDataCollectionAndReportingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicalDataCollectionAndReportingApplication.class, args);
    }



    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
