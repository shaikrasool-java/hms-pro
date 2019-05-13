package com.nareshit.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.dao.IPatientDao;
import com.nareshit.domain.Patient;

@Repository
public class PatientDaoImpl  implements IPatientDao{

	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Patient addPatient(Patient p) {
		Session session=sf.openSession();
		session.save(p);
		session.beginTransaction().commit();
		
		return p;
	}

	@Override
	public Patient updatePatient(Patient p) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(p);
		tx.commit();
		return p;
	}

	@Override
	public void deletePatient(int id) {
			
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Patient p=session.get(Patient.class, id);
		
		if(p!=null) {
			p.setId(id);
			session.delete(p);
		}
		tx.commit();
		session.close();
	}

	@Override
	public Patient getOnepatienById(int id) {
		Session session=sf.openSession();
		Patient p=session.get(Patient.class, id);
		return p;
	}

	@Override
	public Iterator<Patient> getAllPatient() {

		Session session=sf.openSession();
		Iterator<Patient> pList=session.createCriteria(Patient.class).list().iterator();
		
		return pList;
	}



	@Override
	public List<Patient> searchPatient(String patName, String criteria) {
		Session ses = sf.openSession();
		Query qry = ses.createQuery("from Patient as p where p."+criteria+" like ?");
		qry.setString(0,"%"+patName+"%");
		return qry.list();
		
	}

}
