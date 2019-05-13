package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Address;
import com.nareshit.domain.Doctor;

public interface IDoctorDao {

	
	public Doctor addDocotor(Doctor dr);
	public Doctor updateDoctor(Doctor dr);
	public void deleteDoctor(int id);
	public Doctor getOneDoctor(int id);
	public List<Doctor> getAllDoctors();
	public List<Doctor> searchDoctor(String name, String email);
	
	
	
	
}
