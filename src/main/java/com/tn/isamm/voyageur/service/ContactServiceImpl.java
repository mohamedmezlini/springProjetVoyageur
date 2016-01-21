package com.tn.isamm.voyageur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.isamm.voyageur.beans.Contact;
import com.tn.isamm.voyageur.dao.ContactDao;


@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDao dao;

	public Contact findById(int id) {
		return dao.findById(id);
	}

	

	public void saveContact(Contact contact) {
		dao.save(contact);
	}

	
	public void updateContact(Contact contact) {
		
		dao.update(contact);
	}

	
	
	public List<Contact> findAllContacts() {
		return dao.findAllContacts();
	}



	public void deleteContact(int id) {
		dao.deleteById(id);
		
	}



	



	

	
	
}
