package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.NurseBean;
import com.nareshit.domain.Nurse;

public class NurseMapper {
	

	public static Nurse mapBeanToDomain(NurseBean nb) {
			
		Nurse n=new Nurse();
		n.setNid(nb.getId());
		n.setFname(nb.getFname());
		n.setLname(nb.getLname());
		n.setEmail(nb.getEmail());
		n.setMobile(nb.getMobile());
		n.setStatus((Boolean.parseBoolean(nb.getStatus())));
		n.setId(nb.getId());
		
		return n;
	}
	
	public static NurseBean mapDomainToBean(Nurse n) {
		
		NurseBean nb=new NurseBean();
		nb.setId(n.getId());
		nb.setFname(n.getFname());
		nb.setLname(n.getLname());
		nb.setEmail(n.getEmail());
		nb.setPassword(n.getPassword());
		nb.setConpassword(n.getConpassword());
		nb.setMobile(n.getMobile());
		nb.setId(n.getId());
		boolean pst=n.isStatus();
		nb.setStatus(String.valueOf(pst));
		return nb;
	}

	public static List<NurseBean> mapDomainListToBean(Iterator<Nurse> nrDomainList) {
		List<NurseBean> nrBeanList=null;
		if(nrDomainList !=null) {
			nrBeanList = new ArrayList<NurseBean>();
			while(nrDomainList.hasNext()) {
				nrBeanList.add(mapDomainToBean(nrDomainList.next()));
				
			}
		}
		return nrBeanList;
	}


}
