package com.tn.isamm.voyageur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.isamm.voyageur.beans.Client;
import com.tn.isamm.voyageur.dao.ClientDao;


@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDao dao;

	public Client findById(int id) {
		return dao.findById(id);
	}

	

	public void saveClient(Client client) {
		dao.save(client);
	}

	
	public void updateClient(Client client) {
		
		dao.update(client);
	}

	
	
	public List<Client> findAllClients() {
		return dao.findAllClients();
	}



	public void deleteClient(int id) {
		dao.deleteById(id);
		
	}



	public Boolean isValidUser(String login, String pwd) {
		// TODO Auto-generated method stub
		return dao.isValidUser(login, pwd); 
	}



	public List<Client> findByString(String value) {
		
		return dao.findByString(value);
	}



	



	

	
	
}
