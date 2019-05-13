package com.nareshit.dao;

import java.util.Iterator;

import com.nareshit.domain.Admin;

public interface IAdminDao {

	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public void deleteAdmin(int id);
	public Admin getOneAdmin(int id);
	public Iterator<Admin> getAllAdmins();
	public Iterator<Admin> searchAdmin(String name);

}
