package net.myapp.hbr.dao;

import net.myapp.dao.model.Order;

public interface OrderDAO {
	
	public void add(Order order);
	public void delete(Order order);
}
