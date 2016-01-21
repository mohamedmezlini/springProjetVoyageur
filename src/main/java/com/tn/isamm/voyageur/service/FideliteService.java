package com.tn.isamm.voyageur.service;

import java.util.List;

import com.tn.isamm.voyageur.beans.Fidelite;


public interface FideliteService {
	
	Fidelite findById(int id);
		
	void saveFidelite(Fidelite fidelite);
	
	void updateFidelite(Fidelite fidelite);
	
	void deleteFidelite(int id);

	List<Fidelite> findAllFidelites(); 
	
}