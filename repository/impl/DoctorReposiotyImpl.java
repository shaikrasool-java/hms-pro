package com.nareshit.repository.impl;


import com.nareshit.domain.Doctor;
import com.nareshit.repository.IDoctorRepository;

public class DoctorReposiotyImpl implements IDoctorRepository {

	@Override
	public <S extends Doctor> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Doctor> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Doctor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Doctor> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Doctor entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Doctor> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
/*@Override
public List<Patient> addPatient(Patient p) {
	// TODO Auto-generated method stub
	return null;
}*/
}
