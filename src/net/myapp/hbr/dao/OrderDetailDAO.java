package net.myapp.hbr.dao;

import java.util.Set;

import net.myapp.dao.model.OrderDetail;

public interface OrderDetailDAO {
  public void add(OrderDetail orderDetail);
  
  public void add(Set<OrderDetail> odList);
  
  
  
  public void delete(OrderDetail orderDetail);
}
