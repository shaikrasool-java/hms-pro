package com.nareshit.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class NurseBean extends UserBean implements Serializable {

	/**
	 * Rasool
	 */
	private static final long serialVersionUID = 1L;

	
	private List<PatientBean> pinfo;

	

	private byte[] image;
	//setters and gettters
	
	public List<PatientBean> getPinfo() {
		return pinfo;
	}


	public void setPinfo(List<PatientBean> pinfo) {
		this.pinfo = pinfo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((pinfo == null) ? 0 : pinfo.hashCode());
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
		NurseBean other = (NurseBean) obj;
		if (!Arrays.equals(image, other.image))
			return false;
		if (pinfo == null) {
			if (other.pinfo != null)
				return false;
		} else if (!pinfo.equals(other.pinfo))
			return false;
		return true;
	}

}
