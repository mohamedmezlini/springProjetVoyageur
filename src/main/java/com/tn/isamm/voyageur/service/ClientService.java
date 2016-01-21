package com.tn.isamm.voyageur.service;

import java.util.List;

import com.tn.isamm.voyageur.beans.Client;
import com.tn.isamm.voyageur.beans.Voyage;


public interface ClientService {
	
	Client findById(int id);
		
	void saveClient(Client client);
	
	void updateClient(Client client);
	
	void deleteClient(int id);

	List<Client> findByString(String value);

	List<Client> findAllClients(); 
	Boolean isValidUser(String login, String pwd); 
	
}