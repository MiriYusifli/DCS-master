package net.myapp.form.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderAddJSONRequest {
	
List<OrderDetailJSON> orderList=new ArrayList<>();


//cox maraqli bir sebeb tapdim default construvtor olmalidir
public OrderAddJSONRequest() { }

public OrderAddJSONRequest(List<OrderDetailJSON> orderList) {
	super();
	this.orderList = orderList;
}

public List<OrderDetailJSON> getOrderList() {
	return orderList;
}

public void setOrderList(List<OrderDetailJSON> orderList) {
	this.orderList = orderList;
}



	
}
