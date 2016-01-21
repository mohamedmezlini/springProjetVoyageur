package com.tn.isamm.voyageur.dao;

import java.util.List;

import com.tn.isamm.voyageur.beans.Client;


public interface ClientDao {

	Client findById(int id);

	List<Client> findByString(String champ);
	
	
	void save(Client client);

	void deleteById(int id);
	
	void update(Client client);
	
	List<Client> findAllClients();
	public boolean isValidUser(String login, String pwd) ; 

}

