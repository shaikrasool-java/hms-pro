package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.AdminBean;
import com.nareshit.bean.DoctorBean;
import com.nareshit.domain.Admin;
import com.nareshit.domain.Doctor;


public class AdminMapper {

	public static Admin mapBeanToDomain(AdminBean adBean) {

		Admin ad=new Admin();
		ad.setAid(adBean.getId());
		ad.setFname(adBean.getFname());
		ad.setLname(adBean.getLname());
		ad.setEmail(adBean.getEmail());
		ad.setPassword(adBean.getPassword());
		ad.setConpassword(adBean.getConpassword());
		ad.setMobile(adBean.getMobile());
		ad.setStatus(Boolean.parseBoolean(adBean.getStatus()));
		ad.setId(adBean.getId());
		List<Doctor> ldr=null;

		List<DoctorBean> ldrb=adBean.getDrInfo();

		if(ldrb !=null && ldrb.size()>0) {
			ldr=new ArrayList<Doctor>();

			for(DoctorBean drb:ldrb) {
				ldr.add(DoctorMapper.mapBeanToDomain(drb));
			}
			ad.setDoctorsList(ldr);
		}

		return ad;
	}


	public static AdminBean mapDomainToBean(Admin a) {
		
		AdminBean adbe=new AdminBean();
		
		adbe.setId(a.getId());
		adbe.setFname(a.getFname());
		adbe.setLname(a.getLname());
		adbe.setEmail(a.getEmail());
		adbe.setPassword(a.getPassword());
		adbe.setConpassword(a.getConpassword());
		adbe.setMobile(a.getMobile());

		boolean st=a.isStatus();
		adbe.setStatus(String.valueOf(st));
		
		
		List<DoctorBean> ldrb=null;
		
		List<Doctor> ld=a.getDoctorsList();
		
		
				
		if(ld !=null && ld.size()>0) {
			ldrb=new ArrayList<DoctorBean>();
			
			for(Doctor dr:ld) {
				ldrb.add(DoctorMapper.mapDomainToBean(dr));
			}
			adbe.setDrInfo(ldrb);
		}
		
		return adbe;
		
	}
	
	
	public static List<AdminBean> mapDominListToBean(Iterator<Admin> admList){
		List<AdminBean> admBeansList=null;
		if(admList !=null) {
			admBeansList=new ArrayList<AdminBean>();
			while(admList.hasNext()) {
				admBeansList.add(mapDomainToBean(admList.next()));
			}
		}
		
		return admBeansList;
	}
	
	
}
