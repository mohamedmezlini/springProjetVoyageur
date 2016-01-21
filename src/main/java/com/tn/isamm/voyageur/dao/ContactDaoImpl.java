package com.tn.isamm. voyageur.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.tn.isamm. voyageur.beans.Contact;



@Repository(" contactDao")
public class ContactDaoImpl extends AbstractDao<Integer, Contact> implements ContactDao {

	public Contact findById(int id) {
		Contact  contact = getByKey(id);
		if( contact!=null){
			Hibernate.initialize( contact.getClient());
		}
		return  contact;
	}

	
	@SuppressWarnings("unchecked")
	public List<Contact> findAllContacts() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("idContact"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Contact>  contacts = (List<Contact>) criteria.list();
		
	
		return  contacts;
	}

	public void save(Contact  contact) {
		persist( contact);
	}

	
	

	public void update(Contact contact) {
		Contact entity = findById(contact.getIdContact());
	if(entity!=null){
		entity.setObjet(contact.getObjet());
		entity.setSujet(contact.getSujet());
		entity.setRepondre(contact.getRepondre());
		}
		
	}


	public void deleteById(int id) {
		
		Criteria crit = createEntityCriteria();
	crit.add(Restrictions.eq("idContact", id));
	Contact  contact = (Contact)crit.uniqueResult();
	delete( contact);
		
	}


	


}
