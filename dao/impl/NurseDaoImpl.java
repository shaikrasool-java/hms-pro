package com.nareshit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.dao.INurseDao;
import com.nareshit.domain.Nurse;

@Repository
public class NurseDaoImpl implements INurseDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Nurse addNurse(Nurse n) {
		
		Session ses=sf.openSession();
		ses.save(n);
		ses.beginTransaction().commit();

		return n;
	}

	@Override
	public Nurse updateNurse(Nurse n) {

		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		ses.update(n);
		tx.commit();
		return n;
	}

	@Override
	public void deleteNurse(int id) {
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		Nurse n=ses.get(Nurse.class, id);
		
		if(n!=null) {
			n.setId(id);
			ses.delete(n);
		}tx.commit();
		ses.close();
		
	}

	@Override
	public Nurse getOneNurseById(int id) {
		Session ses=sf.openSession();
		Nurse n=ses.get(Nurse.class, id);
		
		return n;
	}

	@Override
	public List<Nurse> getAllNurse() {
		Session ses=sf.openSession();
		List<Nurse> nList=(List<Nurse>) ses.createCriteria(Nurse.class);
		
		return nList;
	}

	@Override
	public List<Nurse> searchNurse(String name, String nur) {
			Session ses=sf.openSession();
			
			Query qry=ses.createQuery("from Nurse as n where n. "+nur+" like ?");
		qry.setString(0, "%"+name+"%");
		return qry.list();
	}

}
