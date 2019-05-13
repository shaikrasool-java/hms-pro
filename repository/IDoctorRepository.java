package com.nareshit.repository;


import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Doctor;

public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {

/*	public List<Patient> addPatient(Patient p);
*/	
}
