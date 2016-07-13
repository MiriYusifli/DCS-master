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
import net.myapp.helper.dao.DataUtilStrParameter;
import net.myapp.validity.user.UserValidity;

@Repository
public class UserDAOImpl {
    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
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
    public List<Object[]> getTest(UserCard card) throws UserNotFoundException, UserNotValidPinException {
        Session session = this.sessionFactory.getCurrentSession(); 
        
        DataUtilStrParameter.clean();//for re initialized parameters list
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
        	DataUtilStrParameter.add(card.getUser().getEmail());
        }
        if(!CommonUtil.isNullOrEmpty(card.getUser().getPin())) {
        	if (!UserValidity.checkPin(card.getUser().getPin()))  throw new UserNotValidPinException(card.getUser().getPin());  
        	hql+=" AND  u.pin=?";
        	DataUtilStrParameter.add(card.getUser().getPin());
        }
        if(!CommonUtil.isNullOrEmpty(card.getCard().getCode())) {
        	hql+=" AND  c.code=?";
        	DataUtilStrParameter.add(card.getCard().getCode());
        }
        if(!CommonUtil.isNull(card.getId()) && card.getId()!=0) {
        	hql=hql+" AND  uc.id=?";
        	DataUtilStrParameter.add(card.getId());
        }
        System.out.println("hql is "+hql);
        Query query = session.createQuery(hql);
        DataUtilStrParameter.setParameter(query);
       // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List list = query.list();
        List<Object[]> list = query.list();
        
        if (CommonUtil.isEmpty(list))  throw new UserNotFoundException("---");
		/*for(Object[] arr : list){
			UserCard userCard=(UserCard) arr[0];
	     	Order order=(Order) arr[1];
			System.out.println(userCard.getBalance()+"   "+order.getTotal_amount());
		} 
		*/return list;
    }
    
}
