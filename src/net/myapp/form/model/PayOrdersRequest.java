package net.myapp.form.model;

import net.myapp.dao.model.UserCard;

public class PayOrdersRequest {
	int payment_option;
	UserCard userCard;
	double payment_discount;
	double payment_price;
	
	
	public int getPayment_option() {
		return payment_option;
	}
	public void setPayment_option(int payment_option) {
		this.payment_option = payment_option;
	}
	public UserCard getUserCard() {
		return userCard;
	}
	public void setUserCard(UserCard userCard) {
		this.userCard = userCard;
	}
	
	
	public double getPayment_discount() {
		return payment_discount;
	}
	public void setPayment_discount(double payment_discount) {
		this.payment_discount = payment_discount;
	}
	public double getPayment_price() {
		return payment_price;
	}
	public void setPayment_price(double payment_price) {
		this.payment_price = payment_price;
	}

	
}
