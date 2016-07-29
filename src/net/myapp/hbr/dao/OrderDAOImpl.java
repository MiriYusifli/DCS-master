package net.myapp.hbr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.myapp.dao.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO{

	
	 private SessionFactory sessionFactory;
	    
	    
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	

	@Override
	public void add(Order order) {

		Session session = this.sessionFactory.getCurrentSession();
        session.persist(order);
		
	}

	@Override
	public void delete(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(order);	
	}

	
}
