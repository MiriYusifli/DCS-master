package net.myapp.hbr.dao;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.myapp.dao.model.OrderDetail;


@Repository
public class OrderDetailDAOImpl  implements OrderDetailDAO{

	private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public void add(OrderDetail orderDetail) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(orderDetail);		
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(orderDetail);			
	}

	@Override
	public void add(Set<OrderDetail> odList) {
		
		for (Iterator iterator = odList.iterator(); iterator.hasNext();) {
			OrderDetail orderDetail = (OrderDetail) iterator.next();
			Session session = this.sessionFactory.getCurrentSession();
	        session.persist(orderDetail);
		}
		
	}

	
	
}
