package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.NurseBean;
import com.nareshit.domain.Nurse;

public interface INurseService {

	public NurseBean getNurseById(int id);
	public void deleteNurse(int id);
	public NurseBean updateNurse(NurseBean nBean);
	public List<NurseBean> getAllNurses();
	public List<NurseBean> searchNurse(String name, String criteria);
	public List<Nurse> findNurseByName(String lowerCase);
	public NurseBean saveNurse(Nurse n);
	public NurseBean updateNurse(Nurse n);
}
