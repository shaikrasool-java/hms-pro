package com.nareshit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nareshit.bean.DoctorBean;
import com.nareshit.dao.IDoctorDao;
import com.nareshit.dao.IRoleDao;
import com.nareshit.domain.Doctor;
import com.nareshit.service.IDoctorService;
import com.nareshit.utility.DoctorMapper;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorDao doctorDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	/*@Override
	public DoctorBean saveDoctor(DoctorBean doctorBean) {
		
		Doctor dr=DoctorMapper.mapBeanToDomain(doctorBean);
		dr=doctorDao.addDocotor(dr);
		doctorBean= DoctorMapper.mapDomainToBean(dr);
		return doctorBean;
		
	}
	*/
	
	@Override
	public DoctorBean saveDoctor(DoctorBean doctBean) {
		Doctor dr=mapBeanToDomain(doctBean);
		Doctor d=doctorDao.addDocotor(dr);
		return DoctorMapper.mapDomainToBean(d);
	}
	

	@Override
	public void deleteDoctor(int id) {

		doctorDao.deleteDoctor(id);
	}

	@Override
	public DoctorBean updateDoctor(DoctorBean doctorBean) {

		Doctor dr=DoctorMapper.mapBeanToDomain(doctorBean);
		dr=doctorDao.updateDoctor(dr);
		doctorBean=DoctorMapper.mapDomainToBean(dr);
		
		return doctorBean;
	}
	@Override
	public DoctorBean getDoctorById(int id) {

		Doctor dr=doctorDao.getOneDoctor(id);
		DoctorBean doctorBean=DoctorMapper.mapDomainToBean(dr);
		
		return doctorBean;
	}


	@Override
	public List<DoctorBean> getAllDoctors() {
		List<Doctor> drList = doctorDao.getAllDoctors();
		List<DoctorBean> doctBeanList = DoctorMapper.mapDomainListToBean(drList.iterator());
		return doctBeanList;
	}





@Override
public List<Doctor> findDoctorByName(String lowerCase) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<DoctorBean> searchDoctor(String name, String serachValue) {
	String criteria = "";
	if (serachValue.equals("Name")) {
		criteria = criteria + "fname";
	} else {
		criteria = criteria + "email";
	}
	List<Doctor> doctList = doctorDao.searchDoctor(name, criteria);

	List<DoctorBean> doctBeanList = DoctorMapper.mapDomainListToBean(doctList.iterator());
	return doctBeanList;
}


public Doctor mapBeanToDomain(DoctorBean doctBean) {
	Doctor doct = new Doctor();
	if(doctBean.getId() > 0) {
		doct.setId(doctBean.getId());
	}
	
	String pwdSathHash = pwdEncoder.encode(doctBean.getPassword());
	String cpwdSaltHash = pwdEncoder.encode(doctBean.getConpassword());
	
	/*doct.setPassword(doctBean.getPassword());
	doct.setConpassword(doctBean.getCpassword());*/
	doct.setPassword(pwdSathHash);
	doct.setConpassword(cpwdSaltHash);
	doct.setEmail(doctBean.getEmail());
	doct.setFname(doctBean.getFname());
	doct.setMobile(doctBean.getMobile());
	doct.setSpecialist(doctBean.getSpecialist());
	doct.setExperience(doctBean.getExperience());
	
	doct.setRole(roleDao.getRoleByName(doctBean.getRole()));
	
	
	//doct.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(doctBean.getStatus()))));
	doct.setStatus(Boolean.parseBoolean(doctBean.getStatus()));
	
	return doct;
	

}


@Override
public DoctorBean saveDoctor(Doctor dr) {
	// TODO Auto-generated method stub
	return null;
}



}
