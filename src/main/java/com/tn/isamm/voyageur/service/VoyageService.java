package com.tn.isamm.voyageur.service;

import java.util.List;

import com.tn.isamm.voyageur.beans.Voyage;


public interface VoyageService {
	
	Voyage findById(int id);
		
	void saveVoyage(Voyage voyage);
	
	void updateVoyage(Voyage voyage);
	
	void deleteVoyage(int id);

	List<Voyage> findAllVoyages(); 

	List<Voyage> findByString(String value);
	
}