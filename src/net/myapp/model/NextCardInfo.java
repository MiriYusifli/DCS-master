package net.myapp.model;

public class NextCardInfo {
String name;
double needableAmountForPassing;
boolean canGetNewCard=false;
//Date   validTo;
public NextCardInfo(String name, double needableAmountForPassing) {
	super();
	this.name = name;
	this.needableAmountForPassing = needableAmountForPassing;
	if (needableAmountForPassing<0)  canGetNewCard=true;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getNeedableAmountForPassing() {
	return needableAmountForPassing;
}
public void setNeedableAmountForPassing(double needableAmountForPassing) {
	this.needableAmountForPassing = needableAmountForPassing;
}
public boolean isCanGetNewCard() {
	return canGetNewCard;
}
public void setCanGetNewCard(boolean canGetNewCard) {
	this.canGetNewCard = canGetNewCard;
}




}
