package net.myapp.hbr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;
import net.myapp.helper.CommonUtil;
import net.myapp.helper.dao.DataUtilIntParameter;
import net.myapp.helper.dao.DataUtilParameter;
import net.myapp.validity.user.UserValidity;

@Repository
public class UserDAOImpl implements UserDAO{
    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public void add(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    
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
    
    public User getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User p = (User) session.load(User.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
    
    
    
    
    
    
    
    @Transactional
    public List<Object[]> getTest(UserCard card) throws UserNotFoundException, UserNotValidPinException {
        Session session = this.sessionFactory.getCurrentSession(); 
        
        DataUtilParameter.clean();//for re initialized parameters list
        String hql="select u,uc,o,od,g,c,ct from UserCard uc "
				                         +" INNER JOIN uc.orderSet as o"
				                         +" INNER JOIN o.orderDetailSet as od"
				                         +" INNER JOIN od.good as g"
				                         +" INNER JOIN uc.card as c"
				                         +" INNER JOIN c.cardType as ct"
				                         +" INNER JOIN uc.user  as u"
				                         +" Where 1=1 ";
        if(!CommonUtil.isNullOrEmpty(card.getUser().getEmail())) {
        	hql+=" AND  u.email=?";
        	DataUtilParameter.add(card.getUser().getEmail());
        }
        if(!CommonUtil.isNullOrEmpty(card.getUser().getPin())) {
        	if (!UserValidity.checkPin(card.getUser().getPin()))  throw new UserNotValidPinException(card.getUser().getPin());  
        	hql+=" AND  u.pin=?";
        	DataUtilParameter.add(card.getUser().getPin());
        }
        if(!CommonUtil.isNullOrEmpty(card.getCard().getCode())) {
        	hql+=" AND  c.code=?";
        	DataUtilParameter.add(card.getCard().getCode());
        }
        if(!CommonUtil.isNull(card.getId()) && card.getId()!=0) {
        	hql=hql+" AND  uc.id=?";
        	DataUtilParameter.add(card.getId());
        }
        /*if(!CommonUtil.isNull(card.getUser().getId()) && card.getUser().getId()!=0) {
        	hql=hql+" AND  u.id=?";
        	DataUtilParameter.add(card.getUser().getId());
        }*/
        System.out.println("hql is "+hql);
        Query query = session.createQuery(hql);
        DataUtilParameter.setParameter(query);
       // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List list = query.list();
       // System.out.println("query is "+query);
        List<Object[]> list = query.list();
        
        if (CommonUtil.isEmpty(list))  throw new UserNotFoundException("---");
		/*for(Object[] arr : list){
			UserCard userCard=(UserCard) arr[0];
	     	Order order=(Order) arr[1];
			System.out.println(userCard.getBalance()+"   "+order.getTotal_amount());
		} 
		*/return list;
    }
    
    /*
    
    public List<Object[]> getTestIntParam(UserCard card) throws UserNotFoundException, UserNotValidPinException {
        Session session = this.sessionFactory.getCurrentSession(); 
        
        DataUtilIntParameter.clean();//for re initialized parameters list
        String hql="select u,uc,o,od,g,c,ct from UserCard uc "
				                         +" INNER JOIN uc.orderSet as o"
				                         +" INNER JOIN o.orderDetailSet as od"
				                         +" INNER JOIN od.good as g"
				                         +" INNER JOIN uc.card as c"
				                         +" INNER JOIN c.cardType as ct"
				                         +" INNER JOIN uc.user  as u"
				                         +" Where 1=1 ";
      
        if(!CommonUtil.isNull(card.getId()) && card.getId()!=0) {
        	hql=hql+" AND  uc.id=?";
        	DataUtilIntParameter.add(card.getId());
        }
        if(!CommonUtil.isNull(card.getUser()) && !CommonUtil.isNull(card.getUser().getId()) && card.getUser().getId()!=0) {
        	hql=hql+" AND  u.id=?";
        	DataUtilIntParameter.add(card.getUser().getId());
        }
        System.out.println("hql is "+hql);
        Query query = session.createQuery(hql);
        DataUtilIntParameter.setParameter(query);
       // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List list = query.list();
       // System.out.println("query is "+query);
        List<Object[]> list = query.list();
        
        if (CommonUtil.isEmpty(list))  throw new UserNotFoundException("---");
		for(Object[] arr : list){
			UserCard userCard=(UserCard) arr[0];
	     	Order order=(Order) arr[1];
			System.out.println(userCard.getBalance()+"   "+order.getTotal_amount());
		} 
		return list;
    }
    
*/}
