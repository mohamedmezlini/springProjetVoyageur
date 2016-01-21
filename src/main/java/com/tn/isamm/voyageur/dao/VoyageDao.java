package com.tn.isamm.voyageur.dao;

import java.util.List;
import com.tn.isamm.voyageur.beans.Voyage;


public interface VoyageDao {

	Voyage findById(int id);
	
	
	void save(Voyage voyage);

	void deleteById(int id);
	
	void update(Voyage voyage);

	List<Voyage> findAllVoyages();

	List<Voyage> findByString(String value);

}

