package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Nurse;

public interface INurseDao {

	
	
	public Nurse addNurse(Nurse n);
	public Nurse updateNurse(Nurse n);
	public void deleteNurse(int id);
	public Nurse getOneNurseById(int id);
	public List<Nurse> getAllNurse();
	public List<Nurse> searchNurse(String name, String email);
	
	
}
