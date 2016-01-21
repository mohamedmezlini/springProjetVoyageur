package com.tn.isamm. voyageur.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.tn.isamm. voyageur.beans.Newsletter;



@Repository(" newsletterDao")
public class NewsletterDaoImpl extends AbstractDao<Integer, Newsletter> implements NewsletterDao {

	public Newsletter findById(int id) {
		Newsletter  newsletter = getByKey(id);
		
		return  newsletter;
	}

	
	@SuppressWarnings("unchecked")
	public List<Newsletter> findAllNewsletters() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("idNewsletter"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Newsletter>  newsletters = (List<Newsletter>) criteria.list();
		
		// No need to fetch newsletterProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of newsletterProfiles if you want.
		/*
		for(User newsletter : newsletters){
			Hibernate.initialize(newsletter.getUserProfiles());
		}*/
		return  newsletters;
	}

	public void save(Newsletter  newsletter) {
		persist( newsletter);
	}

	
	

	public void update(Newsletter newsletter) {
		Newsletter entity = findById(newsletter.getIdNewsletter());
	if(entity!=null){
		entity.setMail(newsletter.getMail());
	}
		
	}


	public void deleteById(int id) {
		
		Criteria crit = createEntityCriteria();
	crit.add(Restrictions.eq("idNewsletter", id));
	Newsletter  newsletter = (Newsletter)crit.uniqueResult();
	delete( newsletter);
		
	}


	


}
