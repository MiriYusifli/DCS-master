package net.myapp.hbr.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.Card;


@Repository
public class CardDAOImpl implements CardDAO {

	
private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    public void add(Card p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    public void update(Card p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
    
    
    
    public Card getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Card p = (Card) session.load(Card.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
    
    
    
    
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
