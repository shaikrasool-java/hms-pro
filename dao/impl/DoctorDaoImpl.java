package com.nareshit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.dao.IDoctorDao;
import com.nareshit.domain.Address;
import com.nareshit.domain.Doctor;
@Repository
public class DoctorDaoImpl implements IDoctorDao {

	@Autowired
	private SessionFactory sf;


	@Override
	public Doctor addDocotor(Doctor dr) {
		
		Session session=sf.openSession();
		session.save(dr);
		session.beginTransaction().commit();
		session.close();
		return dr;
	}

	@Override
	public Doctor updateDoctor(Doctor dr) {

		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(dr);
		tx.commit();
		session.close();
		return dr;
	}

	@Override
	public void deleteDoctor(int id) {

		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Doctor dr=session.get(Doctor.class, id);
		if(dr!=null) {
			dr.setId(id);
			session.delete(dr);
		}
		tx.commit();
		session.close();
	}

	@Override
	public Doctor getOneDoctor(int id) {
		Session session=sf.openSession();
		Doctor dr=session.get(Doctor.class, id);
		session.close();
		return dr;

	}
	@Override
	public List<Doctor> getAllDoctors() {
		Session ses = sf.openSession();
		String getAllDoctors = "from Doctor d";
		Query q = ses.createQuery(getAllDoctors);
		return q.list();		
	}

	@Override
	public List<Doctor> searchDoctor(String docName, String criteria) {
		// TODO Auto-generated method stub
		Session ses=sf.openSession();
		Query qry=ses.createQuery("from Doctor as d where d."+criteria+" like ?");
		qry.setString(0, "%"+docName+"%");
		return qry.list();
	}



}
