package com.nareshit.repository.impl;

import com.nareshit.domain.Admin;
import com.nareshit.repository.IAdminRepository;

public class AdminRepositoryImpl implements IAdminRepository {

	@Override
	public <S extends Admin> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Admin> findAll(Iterable<Integer> ids) {
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
	public void delete(Admin entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Admin> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
