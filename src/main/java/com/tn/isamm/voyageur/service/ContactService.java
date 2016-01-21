package com.tn.isamm.voyageur.service;

import java.util.List;

import com.tn.isamm.voyageur.beans.Contact;


public interface ContactService {
	
	Contact findById(int id);
		
	void saveContact(Contact contact);
	
	void updateContact(Contact contact);
	
	void deleteContact(int id);

	List<Contact> findAllContacts(); 
	
}