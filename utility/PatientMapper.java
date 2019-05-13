package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;

public class PatientMapper {
	

	public static Patient mapBeanToDomain(PatientBean pb) {
			
		Patient p=new Patient();
		p.setPid(pb.getId());
		p.setFname(pb.getFname());
		p.setLname(pb.getLname());
		p.setEmail(pb.getEmail());
		p.setMobile(pb.getMobile());
		p.setStatus((Boolean.parseBoolean(pb.getStatus())));
		p.setId(pb.getId());
		
		return p;
	}
	
	public static PatientBean mapDomainToBean(Patient p) {
		
		PatientBean pb=new PatientBean();
		pb.setId(p.getId());
		pb.setFname(p.getFname());
		pb.setLname(p.getLname());
		pb.setEmail(p.getEmail());
		pb.setPassword(p.getPassword());
		pb.setConpassword(p.getConpassword());
		pb.setMobile(p.getMobile());
		pb.setId(p.getId());
		boolean pst=p.isStatus();
		pb.setStatus(String.valueOf(pst));
		return pb;
	}

	public static List<PatientBean> mapDomainListToBean(Iterator<Patient> ptDomainList) {
		List<PatientBean> ptBeanList=null;
		if(ptDomainList !=null) {
			ptBeanList = new ArrayList<PatientBean>();
			while(ptDomainList.hasNext()) {
				ptBeanList.add(mapDomainToBean(ptDomainList.next()));
				
			}
		}
		return ptBeanList;
	}

}
