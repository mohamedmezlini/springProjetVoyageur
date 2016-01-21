package com.tn.isamm.voyageur.service;

import java.util.List;

import com.tn.isamm.voyageur.beans.Newsletter;


public interface NewsletterService {
	
	Newsletter findById(int id);
		
	void saveNewsletter(Newsletter newsletter);
	
	void updateNewsletter(Newsletter newsletter);
	
	void deleteNewsletter(int id);

	List<Newsletter> findAllNewsletters(); 
	
}