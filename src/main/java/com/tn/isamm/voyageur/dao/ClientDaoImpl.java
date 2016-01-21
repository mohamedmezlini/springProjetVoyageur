package com.tn.isamm.voyageur.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tn.isamm.voyageur.beans.Compte;
import com.tn.isamm.voyageur.beans.Client;

@Repository(" clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	public Client findById(int id) {
		Client client = getByKey(id);
		if (client != null) {
			Hibernate.initialize(client.getVoyages());
			Hibernate.initialize(client.getContacts());
		}
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAllClients() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("idClient"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<Client> clients = (List<Client>) criteria.list();

		// No need to fetch clientProfiles since we are not showing them on list
		// page. Let them lazy load.
		// Uncomment below lines for eagerly fetching of clientProfiles if you
		// want.
		/*
		 * for(User client : clients){
		 * Hibernate.initialize(client.getUserProfiles()); }
		 */
		return clients;
	}

	public void save(Client client) {

		Compte compte = new Compte();
		compte.setSolde(10000.0);

		client.setCompte(compte);
		persist(client);
	}

	public void update(Client client) {
		Client entity = findById(client.getIdClient());
		if (entity != null) {
			entity.setMdp(client.getMdp());
			entity.setNom(client.getNom());
			entity.setPrenom(client.getPrenom());
			entity.setMail(client.getMail());
			entity.setAdresse(client.getAdresse());
			entity.setAge(client.getAge());
			entity.setCin(client.getCin());
			entity.setLogin(client.getLogin());
			entity.setTel(client.getTel());
		}

	}

	public void deleteById(int id) {

		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("idClient", id));
		Client client = (Client) crit.uniqueResult();
		delete(client);

	}

	public boolean isValidUser(String login, String pwd)  {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("mdp", pwd));
		crit.add(Restrictions.eq("login", login)); 
		Client client = (Client) crit.uniqueResult();
		
		if(client!=null)			
			if (client.getRole()==1) 
			return true ; 
			 
		return false; 
		
	}

	@SuppressWarnings("deprecation")
	public List<Client> findByString(String value) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Expression.disjunction()
			        .add(Expression.like("nom", value))
			        .add(Expression.like("login", value))
			        .add(Expression.like("mail", value)));
		
		List<Client> clients = (List<Client>) criteria.list();
		
		

		
		return clients;
	}

}
