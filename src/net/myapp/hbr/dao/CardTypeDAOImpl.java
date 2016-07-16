package net.myapp.hbr.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.myapp.dao.model.CardType;



@Repository
public class CardTypeDAOImpl {

	private SessionFactory sessionFactory;
	
	
	 public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	
	
    @Transactional
	public CardType getByType(int type_id){
    	Session session = this.sessionFactory.getCurrentSession();      
        CardType p = (CardType) session.load(CardType.class, new Integer(type_id));
        
        
		return p;
		
		
	}
    
    
    @Transactional
	public CardType getTopCardType(){
    	Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(CardType.class);
		cr.setProjection(Projections.max("id"));
		
		int cardTypeId=(int) cr.uniqueResult();
		CardType cardType=this.getByType(cardTypeId);
		
		return cardType;
	}

	
}
