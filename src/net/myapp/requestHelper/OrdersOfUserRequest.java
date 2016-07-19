package net.myapp.requestHelper;

import java.util.ArrayList;
import java.util.List;
import net.myapp.dao.model.Good;
import net.myapp.dao.model.Order;
import net.myapp.model.OrdersOfUser;

public class OrdersOfUserRequest {
	public static List<OrdersOfUser>  ordersOfUserList (List<Object[]> usercardList){
		List<OrdersOfUser>ordersOfUserList=new ArrayList<>();
	
		for(Object[] object :usercardList) {
			
			Good good=(Good) object[4];
			Order order=(Order) object[2];
			
		
		
		OrdersOfUser ordersOfUser=new OrdersOfUser();

		
		ordersOfUser.setGood(good.getName());
		ordersOfUser.setPrice(good.getPrice());
		ordersOfUser.setDiscount(order.getTotal_discount());
		ordersOfUser.setCardType_name(order.getUserCard().getCard().getCardType().getName());
		ordersOfUser.setDate(order.getOdate());
		
		
		ordersOfUserList.add(ordersOfUser);
		
		
		}
		
		
		return ordersOfUserList;
	}
}
