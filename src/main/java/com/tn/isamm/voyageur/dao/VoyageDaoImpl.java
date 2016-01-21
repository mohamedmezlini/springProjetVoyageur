package com.tn.isamm.voyageur.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tn.isamm.voyageur.beans.Voyage;



@Repository("voyageDao")
public class VoyageDaoImpl extends AbstractDao<Integer, Voyage> implements VoyageDao {

	public Voyage findById(int id) {
		Voyage voyage = getByKey(id);
		if(voyage!=null){
			Hibernate.initialize(voyage.getClients());
		}
		return voyage;
	}

	
	@SuppressWarnings("unchecked")
	public List<Voyage> findAllVoyages() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("dateDepart"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Voyage> voyages = (List<Voyage>) criteria.list();
		
		
		return voyages;
	}

	public void save(Voyage voyage) {
		persist(voyage);
	}

	
	

	public void update(Voyage voyage) {
		// TODO Auto-generated method stub
		Voyage entity = findById(voyage.getIdVoyage());
		if(entity!=null){
			entity.setDateArrivee(voyage.getDateArrivee());
			entity.setDateDepart(voyage.getDateDepart());
			entity.setIdVoyage(voyage.getIdVoyage()); 
			entity.setImage(voyage.getImage());
			entity.setNbDispo(voyage.getNbDispo());
			entity.setNbVendu(voyage.getNbVendu());
			entity.setPays(voyage.getPays()); 
			entity.setPrix(voyage.getPrix()); 
			entity.setVilleArrivee(voyage.getVilleArrivee()); 
			entity.setVilleDepart(voyage.getVilleDepart());
			
			
			
		
			
		}
		
	}


	public void deleteById(int id) {
		
		Criteria crit = createEntityCriteria();
	crit.add(Restrictions.eq("idVoyage", id));
	Voyage voyage = (Voyage)crit.uniqueResult();
	delete(voyage);
		
	}


	public List<Voyage> findByString(String value) {
		 Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("pays", value));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
		List<Voyage> voyages = (List<Voyage>) criteria.list();
		
		
		return voyages;
		
		
	}


}
