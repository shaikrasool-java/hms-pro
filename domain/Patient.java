package com.nareshit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Doctor doctor;

	@OneToMany
	private Set<Nurse> nurses;

	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pid;

	/*private String gender;
	private Date date;
	private int age;
	private String bloodgroup;*/
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Set<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(Set<Nurse> nurses) {
		this.nurses = nurses;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	
	
	


}
