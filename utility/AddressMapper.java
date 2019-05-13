package com.nareshit.utility;

import com.nareshit.bean.AddressBean;
import com.nareshit.domain.Address;

public class AddressMapper {

	public static Address mapBeanToDomain(AddressBean adBean) {
		
			Address addr=new Address();
			addr.setStreet(adBean.getStreet());
			addr.setCity(adBean.getCity());
			addr.setState(adBean.getState());
			addr.setZipcode(adBean.getZip());
			addr.setCountry(adBean.getCountry());
		
			return addr;
			
	}
	
	public static AddressBean mapDomainToBean(Address adDomain) {
		
		AddressBean ab=new AddressBean();
		
		ab.setStreet(adDomain.getStreet());
		ab.setCity(adDomain.getCity());
		ab.setState(adDomain.getState());
		ab.setZip(adDomain.getZipcode());
		ab.setCountry(adDomain.getCountry());
		
		
		
		
		
		return ab;
		
		
		
	}
	
}
