package com.nareshit.dao.impl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.dao.IAdminDao;
import com.nareshit.domain.Admin;
@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Admin addAdmin(Admin admin) {
		Session session=sf.openSession();
		session.save(admin);
		session.beginTransaction().commit();
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {

		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(admin);
		tx.commit();
		return admin;
	}

	@Override
	public void deleteAdmin(int id) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Admin ad=session.get(Admin.class, id);
		if(ad!=null) {
			ad.setId(id);
			session.delete(ad);
		}
				
		tx.commit();
		session.close();
	}

	@Override
	public Admin getOneAdmin(int id) {

		Session session=sf.openSession();
		Admin ad=session.get(Admin.class, id);
		return ad;
	}

	@Override
	public Iterator<Admin> getAllAdmins() {
			
		Session session=sf.openSession();
		Iterator<Admin> adList=session.createCriteria(Admin.class).list().iterator();
			
		return adList;
	}

	@Override
	public Iterator<Admin> searchAdmin(String name) {

		
		return null;
	}

}
