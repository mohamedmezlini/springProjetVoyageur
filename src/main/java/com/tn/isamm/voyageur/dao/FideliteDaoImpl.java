package com.tn.isamm. voyageur.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.tn.isamm. voyageur.beans.Fidelite;



@Repository(" fideliteDao")
public class FideliteDaoImpl extends AbstractDao<Integer, Fidelite> implements FideliteDao {

	public Fidelite findById(int id) {
		Fidelite  fidelite = getByKey(id);
		
		return  fidelite;
	}

	
	@SuppressWarnings("unchecked")
	public List<Fidelite> findAllFidelites() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("idFidelite"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Fidelite>  fidelites = (List<Fidelite>) criteria.list();
		
		return  fidelites;
	}

	public void save(Fidelite  fidelite) {
		persist( fidelite);
	}

	
	

	public void update(Fidelite fidelite) {
		Fidelite entity = findById(fidelite.getIdFidelite());
	if(entity!=null){
		entity.setFd(fidelite.getFd());
	entity.setReduction(fidelite.getReduction());
	}
		
	}


	public void deleteById(int id) {
		
		Criteria crit = createEntityCriteria();
	crit.add(Restrictions.eq("idFidelite", id));
	Fidelite  fidelite = (Fidelite)crit.uniqueResult();
	delete( fidelite);
		
	}


	


}
