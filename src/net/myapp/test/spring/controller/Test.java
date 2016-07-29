package net.myapp.test.spring.controller;

import java.util.ArrayList;
import java.util.List;

import net.myapp.dao.model.Good;
import net.myapp.dao.model.OrderDetail;
import net.myapp.form.model.OrderAddRequest;

public class Test {

	public static void main(String[] args) {
		List<OrderAddRequest>orderRequestList=new ArrayList<>();
		OrderAddRequest orderAddRequest1=new OrderAddRequest(1,3);
		OrderAddRequest orderAddRequest2=new OrderAddRequest(2, 10);
		orderRequestList.add(orderAddRequest1);
		orderRequestList.add(orderAddRequest2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		OrderDetail orderDetail=new OrderDetail();
		Good good=new Good();
		orderDetail.setGcount(orderAddRequest.getGcount());
		good.setId(orderAddRequest.getGood_id());
		orderDetail.setGood(good);
		Set<OrderDetail> odList=new  HashSet<>();
		odList.add(orderDetail);
		
		
		
		orderService.add(odList, userCard, 1);
		
		}
		
		
	}

}
