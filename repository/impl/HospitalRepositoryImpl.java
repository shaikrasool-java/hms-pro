package com.nareshit.repository.impl;

import java.util.List;

import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;

public class HospitalRepositoryImpl implements IHospitalRepository{

	@Override
	public <S extends Hospital> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Hospital> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Hospital> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Hospital> findAll(Iterable<Integer> ids) {
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
	public void delete(Hospital entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Hospital> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hospital> findHospitalByName(String name) {
			// TODO Auto-generated method stub
		return null;
	}

}
