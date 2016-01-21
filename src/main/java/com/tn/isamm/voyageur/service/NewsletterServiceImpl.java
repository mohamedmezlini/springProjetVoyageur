package com.tn.isamm.voyageur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.isamm.voyageur.beans.Newsletter;
import com.tn.isamm.voyageur.dao.NewsletterDao;


@Service("newsletterService")
@Transactional
public class NewsletterServiceImpl implements NewsletterService{

	@Autowired
	private NewsletterDao dao;

	public Newsletter findById(int id) {
		return dao.findById(id);
	}

	

	public void saveNewsletter(Newsletter newsletter) {
		dao.save(newsletter);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateNewsletter(Newsletter newsletter) {
		
		dao.update(newsletter);
	}

	
	
	public List<Newsletter> findAllNewsletters() {
		return dao.findAllNewsletters();
	}



	public void deleteNewsletter(int id) {
		dao.deleteById(id);
		
	}



	



	

	
	
}
