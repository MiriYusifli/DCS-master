package net.myapp.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.Good;
import net.myapp.dao.model.Order;
import net.myapp.dao.model.OrderDetail;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.UserCard;
import net.myapp.form.model.PayOrdersRequest;
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
	private UserCardService userCardService;

	
	
	public void setUserCardService(UserCardService userCardService) {
		this.userCardService = userCardService;
	}




	
	
	@Transactional
	@Override
	public void add(Order order){
		
		
		orderDAO.add(order);
		orderDetailDAO.add(order.getOrderDetailSet());

		
	}
	
	
	
	
	@Transactional
	@Override
	public void add(Set<OrderDetail> odList,int sellerID,PayOrdersRequest payOrdersRequest){
		Order order=odList.iterator().next().getOrder();
		SecureUser secureUser=new SecureUser();
		
		//c test ucundur
		
		
		
		UserCard userCard=userCardService.payOrders(payOrdersRequest,10);

		
		secureUser.setId(sellerID);
		order.setSecureUser(secureUser);
		order.setUserCard(userCard);
		order.setOrderDetailSet(odList);
		order.setTotal_amount(payOrdersRequest.getPayment_price());
		order.setTotal_discount(payOrdersRequest.getPayment_discount());
		
		
		
		
		
		//test ucun
		// eslinde bu dateler baza terefinden daxil olunmalidi diesen ama table da qoyulmadigi
		//ucun mende deyisdirmedim ki bazalarimizda ferq olmasin
		Date date=new Date();
		order.setOdate(date);
		order.setOtime(date);
		//test ucun
		
		
		
		this.add(order);
		
		
		
		
	}




	
	
	
}
