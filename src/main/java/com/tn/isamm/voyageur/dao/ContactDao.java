package com.tn.isamm.voyageur.dao;

import java.util.List;
import com.tn.isamm.voyageur.beans.Contact;


public interface ContactDao {

	Contact findById(int id);
	
	
	void save(Contact contact);

	void deleteById(int id);
	
	void update(Contact contact);
	
	List<Contact> findAllContacts();

}

