package com.nareshit.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.NurseBean;
import com.nareshit.dao.INurseDao;
import com.nareshit.dao.IPatientDao;
import com.nareshit.domain.Nurse;
import com.nareshit.service.INurseService;
import com.nareshit.utility.NurseMapper;
@Service
public class NurseServiceImpl implements INurseService{

	@Autowired
	private INurseDao dao;

	
	
	
	@Override
	public NurseBean saveNurse(Nurse n) {
	
		Nurse nt=dao.addNurse(n);
		return NurseMapper.mapDomainToBean(nt);
		
	}
	
	
	@Override
	public NurseBean getNurseById(int id) {
	
		Nurse n=dao.getOneNurseById(id);
		NurseBean nBean=NurseMapper.mapDomainToBean(n);
		return nBean;
	}

	@Override
	public void deleteNurse(int id) {
		dao.deleteNurse(id);
	}
	@Override
	public NurseBean updateNurse(Nurse n) {
		n=dao.updateNurse(n);
		return NurseMapper.mapDomainToBean(n);
	}

	@Override
	public NurseBean updateNurse(NurseBean nBean) {
		
		Nurse n=NurseMapper.mapBeanToDomain(nBean);
		n=dao.updateNurse(n);
		nBean=NurseMapper.mapDomainToBean(n);
		return nBean;
	}

	@Override
	public List<NurseBean> getAllNurses() {
		Iterator<Nurse> nList=(Iterator<Nurse>) dao.getAllNurse();
		return NurseMapper.mapDomainListToBean(nList);
	}

	@Override
	public List<NurseBean> searchNurse(String name, String searchValue) {
		
		String nurse="";
		if(searchValue.equals("Name")) {
			nurse=nurse+"fname";
		}
		else {
			nurse=nurse+"email";
		}
		List<Nurse> nList=dao.searchNurse(name, nurse);
		List<NurseBean> nBeanList=NurseMapper.mapDomainListToBean(nList.iterator());
		
		return nBeanList;
	}

	@Override
	public List<Nurse> findNurseByName(String lowerCase) {
		// TODO Auto-generated method stub
		return null;
	}



}
