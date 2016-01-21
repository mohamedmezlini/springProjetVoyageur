package com.tn.isamm.voyageur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.isamm.voyageur.beans.Voyage;
import com.tn.isamm.voyageur.dao.VoyageDao;


@Service("voyageService")
@Transactional
public class VoyageServiceImpl implements VoyageService{

	@Autowired
	private VoyageDao dao;

	public Voyage findById(int id) {
		return dao.findById(id);
	}

	

	public void saveVoyage(Voyage voyage) {
		dao.save(voyage);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateVoyage(Voyage voyage) {
		dao.update(voyage);
	}

	
	
	public List<Voyage> findAllVoyages() {
		return dao.findAllVoyages();
	}



	public void deleteVoyage(int id) {
		dao.deleteById(id);
		
	}



	public List<Voyage> findByString(String value) {
		return dao.findByString(value);
	}



	



	

	
	
}
