package com.nareshit.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Hospital hospital;
	
	public Hospital getHospital() {
		return hospital;
	}



	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}



	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}



	public void setDoctorsList(List<Doctor> doctorsList) {
		this.doctorsList = doctorsList;
	}



	@OneToMany
	private List<Doctor> doctorsList;
	
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aid")
	private Integer aid;	
	
	public Integer getAid() {
		return aid;
	}



	public void setAid(Integer aid) {
		this.aid = aid;
	}


}