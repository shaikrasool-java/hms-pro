package com.nareshit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Patient;

public interface IPatientRepository extends CrudRepository<Patient, Integer> {

}
