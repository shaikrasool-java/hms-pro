package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Patient;

public class DoctorMapper {

	public static Doctor mapBeanToDomain(DoctorBean drb){
		Doctor dr=new Doctor();
		dr.setId(drb.getId());
		
		dr.setFname(drb.getFname());
		dr.setLname(drb.getLname());
		dr.setMobile(drb.getMobile());
		dr.setEmail(drb.getEmail());
		dr.setPassword(drb.getPassword());
		dr.setConpassword(drb.getConpassword());
		dr.setSpecialist(drb.getSpecialist());
		dr.setStatus(Boolean.parseBoolean(drb.getStatus()));

		List<Patient> lp=null;
		List<PatientBean> lpb=drb.getPinfo();
		if(lpb !=null && lpb.size()>0) {
			lp=new ArrayList<Patient>();
			for(PatientBean pb:lpb) {
				lp.add(PatientMapper.mapBeanToDomain(pb));
			}
			dr.setPatients(lp);
		}

		return dr;
	}

	public static DoctorBean mapDomainToBean(Doctor dr) {

		DoctorBean drb=new DoctorBean();
		drb.setId(dr.getId());
		drb.setFname(dr.getFname());
		drb.setLname(dr.getLname());
		drb.setMobile(dr.getMobile());
		drb.setEmail(dr.getEmail());
		drb.setPassword(dr.getPassword());
		drb.setConpassword(dr.getConpassword());
		drb.setSpecialist(dr.getSpecialist());
		boolean drs=dr.isStatus();
		drb.setStatus(String.valueOf(drs));
		List<PatientBean> ldb=null;

		List<Patient> lp=dr.getPatients();

		if(lp !=null && lp.size()>0) {
			ldb=new ArrayList <PatientBean>();
			for(Patient p:lp) {

				ldb.add(PatientMapper.mapDomainToBean(p));
			}
			drb.setPinfo(ldb);		
		}

		return drb;
	}
	public static List<DoctorBean> mapDomainListToBean(Iterator<Doctor> drList){
		List<DoctorBean> doctBeansList = null;
		if(drList != null) {
			doctBeansList = new ArrayList<DoctorBean>();
			while(drList.hasNext()) {
				doctBeansList.add(mapDomainToBean(drList.next()));
			}
		}
		return doctBeansList;	}
}
