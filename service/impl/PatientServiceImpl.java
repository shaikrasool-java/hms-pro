package com.nareshit.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.PatientBean;
import com.nareshit.dao.IPatientDao;
import com.nareshit.domain.Patient;
import com.nareshit.service.IPatientService;
import com.nareshit.utility.PatientMapper;
@Service
public class PatientServiceImpl implements IPatientService{

	@Autowired
	private IPatientDao dao;
	
	@Override
	public PatientBean savePatient(Patient pat) {
		Patient patDomain=dao.addPatient(pat);
		return PatientMapper.mapDomainToBean(patDomain);
	}
	

	@Override
	public PatientBean getPatientById(int id) {
		Patient p=dao.getOnepatienById(id);
		PatientBean patBean=PatientMapper.mapDomainToBean(p);
		return patBean;
		
	}

	@Override
	public void deletePatient(int id) {
		dao.deletePatient(id);
	}

	@Override
	public PatientBean updatePatient(PatientBean patBean) {

		Patient p=PatientMapper.mapBeanToDomain(patBean);
		p=dao.updatePatient(p);
		patBean=PatientMapper.mapDomainToBean(p);
		return patBean;
	}

	@Override
	public List<PatientBean> getAllPatients() {
			
		Iterator<Patient> pList=dao.getAllPatient();
		return PatientMapper.mapDomainListToBean(pList);
	}

	@Override
	public List<Patient> findPatientByName(String lowerCase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientBean updatePatient(Patient pat) {
		 pat = dao.updatePatient(pat);
		return PatientMapper.mapDomainToBean(pat);
	}


	@Override
	public List<PatientBean> searchPatient(String patName, String searchValue) {
		String criteria = "";
		if (searchValue.equals("Name")) {
			criteria = criteria + "fname";
		} else {
			criteria = criteria + "email";
		}
		List<Patient> patList=dao.searchPatient(patName, criteria);
		List<PatientBean> patBeanList=PatientMapper.mapDomainListToBean(patList.iterator());
		return patBeanList;		
	}



}
