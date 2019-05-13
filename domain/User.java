package com.nareshit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
public  class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="firstname")
	private String fname;
	@Column(name="lastname")
	private String lname;
	@Column(name="email")
	private String email;
	@Column(name="contact")
	private String mobile;
	@Column(name="pwd")
	private String password;
	@Column(name="cpwd")
	private String conpassword;
	
	
	@OneToOne
	private Role role;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	//private Integer userId;
	
	@Column(name="status")
	private boolean status;





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getFname() {
		return fname;
	}





	public void setFname(String fname) {
		this.fname = fname;
	}





	public String getLname() {
		return lname;
	}





	public void setLname(String lname) {
		this.lname = lname;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getMobile() {
		return mobile;
	}





	public void setMobile(String mobile) {
		this.mobile = mobile;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getConpassword() {
		return conpassword;
	}





	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}





	public boolean isStatus() {
		return status;
	}





	public void setStatus(boolean status) {
		this.status = status;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conpassword == null) ? 0 : conpassword.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (conpassword == null) {
			if (other.conpassword != null)
				return false;
		} else if (!conpassword.equals(other.conpassword))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	

	/*public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	
		
}
