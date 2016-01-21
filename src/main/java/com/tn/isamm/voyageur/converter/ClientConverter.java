package com.tn.isamm.voyageur.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tn.isamm.voyageur.beans.Client;
import com.tn.isamm.voyageur.service.ClientService;

@Component
public class ClientConverter implements Converter<Object, Client>{

	@Autowired
	ClientService clientService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Client convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Client profile= clientService.findById(id);
		System.out.println("Profile : "+profile);
		return profile;
	}

}
