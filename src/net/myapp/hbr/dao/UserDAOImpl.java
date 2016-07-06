package net.myapp.hbr.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.Order;
import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.helper.CommonUtil;

@Repository
public class UserDAOImpl {
    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
    public void add(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    @Transactional
    public void update(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
 
    public List<User> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User").list();
        
        return list;
    }
    @Transactional
    public User getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User p = (User) session.load(User.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
    
    
    
    
    
    
    
    @Transactional
    public List<Object[]> getTest(UserCard card) {
        Session session = this.sessionFactory.getCurrentSession(); 
        String hql="select u,uc,o,od,g,c,ct from UserCard uc "
				                         +" INNER JOIN uc.orderSet as o"
				                         +" INNER JOIN o.orderDetailSet as od"
				                         +" INNER JOIN od.good as g"
				                         +" INNER JOIN uc.card as c"
				                         +" INNER JOIN c.cardType as ct"
				                         +" INNER JOIN uc.user  as u"
				                         +" Where 1=1 ";
        if(CommonUtil.isNullOrEmpty(card.getUser().getEmail())==false)
        {
        	hql=hql+" AND  u.email='"+card.getUser().getEmail()+"'";
        }
        if(CommonUtil.isNullOrEmpty(card.getUser().getPin())==false)
        {
        	hql=hql+" AND  u.pin='"+card.getUser().getPin()+"'";
        }
        if(CommonUtil.isNullOrEmpty(card.getCard().getCode())==false)
        {
        	hql=hql+" AND  c.code='"+card.getCard().getCode()+"'";
        }
        if(CommonUtil.isNull(card.getId())==false && card.getId()!=0)
        {
        	hql=hql+" AND  uc.id='"+card.getId()+"'";
        }
        System.out.println("hql is "+hql);
        Query query = session.createQuery(hql);
       // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List list = query.list();
        List<Object[]> list = query.list();
		/*for(Object[] arr : list){
			UserCard userCard=(UserCard) arr[0];
	     	Order order=(Order) arr[1];
			System.out.println(userCard.getBalance()+"   "+order.getTotal_amount());
		} 
		*/return list;
    }
    
}
