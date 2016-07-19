package net.myapp.model;

import java.util.Date;

public class UserInfo {

	String name,cardType_name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardType_name() {
		return cardType_name;
	}
	public void setCardType_name(String cardType_name) {
		this.cardType_name = cardType_name;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	Date issueDate,lastDate;
	int discount;
	Double balance;
	
}
