package com.example.clinical_data_collection_and_reporting.module;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int age;
}
