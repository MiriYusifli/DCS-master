package net.myapp.hbr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import net.myapp.dao.model.UserCard;

@Repository
public class UserCardDAOImpl implements UserCardDAO {

	
private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
    public void add(UserCard p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    @Transactional
    public void update(UserCard p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
    
    
    @Transactional
    public UserCard getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        UserCard p = (UserCard) session.load(UserCard.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
    
   
}
