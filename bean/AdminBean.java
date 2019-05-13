package com.nareshit.bean;

import java.io.Serializable;
import java.util.List;

public class AdminBean extends UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6509958446997159636L;
	
	
	
	private List<DoctorBean> drInfo;



	public List<DoctorBean> getDrInfo() {
		return drInfo;
	}



	public void setDrInfo(List<DoctorBean> drInfo) {
		this.drInfo = drInfo;
	}
	
	
	
	

}
