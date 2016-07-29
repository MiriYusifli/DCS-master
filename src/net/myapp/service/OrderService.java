package net.myapp.service;

import java.util.List;
import java.util.Set;

import net.myapp.dao.model.Good;
import net.myapp.dao.model.Order;
import net.myapp.dao.model.OrderDetail;
import net.myapp.dao.model.UserCard;

public interface OrderService {
	public void add(Set<OrderDetail> odList,UserCard userCard,int sellerID);

	public void add(Order order);
}