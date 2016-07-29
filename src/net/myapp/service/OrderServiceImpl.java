package net.myapp.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.Good;
import net.myapp.dao.model.Order;
import net.myapp.dao.model.OrderDetail;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.UserCard;
import net.myapp.hbr.dao.OrderDAO;
import net.myapp.hbr.dao.OrderDetailDAO;

public class OrderServiceImpl implements OrderService {

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}




	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}




	private OrderDetailDAO orderDetailDAO;
	private OrderDAO orderDAO;
	
	
	@Transactional
	@Override
	public void add(Order order){
		orderDAO.add(order);
		orderDetailDAO.add(order.getOrderDetailSet());

		
	}
	
	
	
	
	@Transactional
	@Override
	public void add(Set<OrderDetail> odList,UserCard userCard,int sellerID){
		Order order=new Order();
		SecureUser secureUser=new SecureUser();
		secureUser.setId(sellerID);
		order.setSecureUser(secureUser);
		order.setUserCard(userCard);
		order.setOrderDetailSet(odList);
		
		//test ucun
		Date date=new Date();
		order.setOdate(date);
		order.setOtime(date);
		//test ucun
		
		
		
		this.add(order);
		
		
		
		
	}
}
