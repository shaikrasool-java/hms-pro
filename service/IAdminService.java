package com.nareshit.service;

import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.AdminBean;
import com.nareshit.domain.Admin;

public interface IAdminService {

	
	public AdminBean saveAdmin(AdminBean adminBean);
	public void deleteAdmin(int id);
	public AdminBean getAdminById(int id);
	public AdminBean updateAdmin(AdminBean adminBean);
	public List<AdminBean>getAllAdmins();
	public Iterator<Admin>searchAdmin(String name);
	public List<Admin> findAdminByName(String lowerCase);
}
