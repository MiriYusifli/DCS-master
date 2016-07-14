package net.myapp.hbr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.Card;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.helper.CommonUtil;
import net.myapp.helper.dao.DataUtilStrParameter;
  

@Repository
public class CardDAOImpl {

	
private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
    public void add(Card p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    @Transactional
    public void update(Card p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
    
    
    @Transactional
    public Card getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Card p = (Card) session.load(Card.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
    
    
    
    @Transactional
    public Card getByCode(String code) {
        Session session = this.sessionFactory.getCurrentSession(); 
        
        String hql="from Card where code=:code";
        
        Query query = session.createQuery(hql);
        query.setParameter("code", code);

       // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List list = query.list();
        System.out.println("hql is "+query.toString());
        Card card=(Card) query.uniqueResult();
        
		/*for(Object[] arr : list){
			UserCard userCard=(UserCard) arr[0];
	     	Order order=(Order) arr[1];
			System.out.println(userCard.getBalance()+"   "+order.getTotal_amount());
		} 
		*/return card;
    }
}