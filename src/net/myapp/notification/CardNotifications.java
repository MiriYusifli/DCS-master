package net.myapp.notification;

import net.myapp.dao.model.Card;
import net.myapp.dao.model.UserCard;

public class CardNotifications extends Notification {
	public void PassNextCardName(String name){
		

		this.setNotification("next Card: "+name);
		this.seti18nNotfMessageKey("Next_Card_name");
	    this.seti18nNotfMessageArg(name);
		
	}
	
	
	public void PassNextCardBalanceMinus(String  minus){
		this.setNotification("next Card Balance Minus: "+minus);
		this.seti18nNotfMessageKey("Next_Card_balance_minus");
	    this.seti18nNotfMessageArg(minus);
		
	}
	
	
	
	
	
}
