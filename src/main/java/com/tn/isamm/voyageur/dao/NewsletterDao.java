package com.tn.isamm.voyageur.dao;

import java.util.List;
import com.tn.isamm.voyageur.beans.Newsletter;


public interface NewsletterDao {

	Newsletter findById(int id);
	
	
	void save(Newsletter newsletter);

	void deleteById(int id);
	
	void update(Newsletter newsletter);
	
	List<Newsletter> findAllNewsletters();

}

