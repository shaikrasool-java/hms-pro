package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;

public interface IPatientService {

	public PatientBean getPatientById(int id);
	public void deletePatient(int id);
	public PatientBean updatePatient(PatientBean patBean);
	public List<PatientBean> getAllPatients();
	public List<PatientBean> searchPatient(String patName, String criteria);
	public List<Patient> findPatientByName(String lowerCase);
	public PatientBean savePatient(Patient pat);
	public PatientBean updatePatient(Patient pat);
}
