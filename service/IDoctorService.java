package com.nareshit.service;

import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.DoctorBean;
import com.nareshit.domain.Address;
import com.nareshit.domain.Doctor;

public interface IDoctorService {

	public DoctorBean saveDoctor(DoctorBean docBean);
	public void deleteDoctor(int id);
	public DoctorBean updateDoctor(DoctorBean doctorBean);
	public DoctorBean getDoctorById(int id);
	public List<DoctorBean> getAllDoctors();
	public List<Doctor> findDoctorByName(String lowerCase);
	List<DoctorBean> searchDoctor(String name, String serachValue);
	DoctorBean saveDoctor(Doctor dr);
	
	
}
