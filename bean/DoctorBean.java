package com.nareshit.bean;

import java.io.Serializable;
import java.util.List;

public class DoctorBean extends UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<PatientBean> pinfo;

	private String specialist;
	

	private byte[] image;
	//setters and gettters
	
	public List<PatientBean> getPinfo() {
		return pinfo;
	}


	public String getSpecialist() {
		return specialist;
	}


	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}


	public void setPinfo(List<PatientBean> pinfo) {
		this.pinfo = pinfo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pinfo == null) ? 0 : pinfo.hashCode());
		result = prime * result + ((specialist == null) ? 0 : specialist.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorBean other = (DoctorBean) obj;
		if (pinfo == null) {
			if (other.pinfo != null)
				return false;
		} else if (!pinfo.equals(other.pinfo))
			return false;
		if (specialist == null) {
			if (other.specialist != null)
				return false;
		} else if (!specialist.equals(other.specialist))
			return false;
		return true;
	}


	public Object getExperience() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	// hashcode and equals method
	
		

}
