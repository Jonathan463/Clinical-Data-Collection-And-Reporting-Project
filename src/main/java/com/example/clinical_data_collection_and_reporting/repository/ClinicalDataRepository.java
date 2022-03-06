package com.example.clinical_data_collection_and_reporting.repository;

import com.example.clinical_data_collection_and_reporting.module.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
}
