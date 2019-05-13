package com.nareshit.dao;

import java.util.Iterator;
import java.util.List;

import com.nareshit.domain.Patient;

public interface IPatientDao {

	
	
	public Patient addPatient(Patient p);
	public Patient updatePatient(Patient p);
	public void deletePatient(int id);
	public Patient getOnepatienById(int id);
	public Iterator<Patient> getAllPatient();
	public List<Patient> searchPatient(String name, String email);
	
	
}
