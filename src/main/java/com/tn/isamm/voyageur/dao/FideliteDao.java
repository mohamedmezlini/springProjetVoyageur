package com.tn.isamm.voyageur.dao;

import java.util.List;
import com.tn.isamm.voyageur.beans.Fidelite;


public interface FideliteDao {

	Fidelite findById(int id);
	
	
	void save(Fidelite fidelite);

	void deleteById(int id);
	
	void update(Fidelite fidelite);
	
	List<Fidelite> findAllFidelites();

}

