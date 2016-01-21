package com.tn.isamm.voyageur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.isamm.voyageur.beans.Fidelite;
import com.tn.isamm.voyageur.dao.FideliteDao;


@Service("fideliteService")
@Transactional
public class FideliteServiceImpl implements FideliteService{

	@Autowired
	private FideliteDao dao;

	public Fidelite findById(int id) {
		return dao.findById(id);
	}

	

	public void saveFidelite(Fidelite fidelite) {
		dao.save(fidelite);
	}

	public void updateFidelite(Fidelite fidelite) {
		
		dao.update(fidelite);
	}

	
	
	public List<Fidelite> findAllFidelites() {
		return dao.findAllFidelites();
	}



	public void deleteFidelite(int id) {
		dao.deleteById(id);
		
	}



	



	

	
	
}
