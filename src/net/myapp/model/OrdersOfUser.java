package net.myapp.model;

import java.util.Date;

public class OrdersOfUser {
	String good,cardType_name;
	double price,discount;
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public String getCardType_name() {
		return cardType_name;
	}
	public void setCardType_name(String cardType_name) {
		this.cardType_name = cardType_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	Date date;
}
