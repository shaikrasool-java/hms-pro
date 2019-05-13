package com.nareshit.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.AdminBean;
import com.nareshit.dao.IAdminDao;
import com.nareshit.domain.Admin;
import com.nareshit.service.IAdminService;
import com.nareshit.utility.AdminMapper;

@Service
public class AdminServiceImpl implements IAdminService {

	
	@Autowired
	private IAdminDao dao;

	@Override
	public AdminBean saveAdmin(AdminBean adminBean) {

		Admin ad=AdminMapper.mapBeanToDomain(adminBean);
		ad=dao.addAdmin(ad);
		adminBean=AdminMapper.mapDomainToBean(ad);
		return adminBean;
	}

	@Override
	public void deleteAdmin(int id) {
		dao.deleteAdmin(id);
	}

	@Override
	public AdminBean updateAdmin(AdminBean adminBean) {
		
		Admin ad=AdminMapper.mapBeanToDomain(adminBean);
		ad=dao.updateAdmin(ad);
		adminBean=AdminMapper.mapDomainToBean(ad);
		return adminBean;
	}
	@Override
	public AdminBean getAdminById(int id) {

		Admin ad=dao.getOneAdmin(id);
		AdminBean adminBean=AdminMapper.mapDomainToBean(ad);
		
		return adminBean;
	}

	@Override
	public List<AdminBean> getAllAdmins() {

		Iterator<Admin> adList=dao.getAllAdmins();
		
		return AdminMapper.mapDominListToBean(adList);
	}

	@Override
	public Iterator<Admin> searchAdmin(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAdminByName(String lowerCase) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
