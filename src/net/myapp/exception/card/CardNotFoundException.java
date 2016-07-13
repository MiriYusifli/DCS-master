package net.myapp.exception.card;

import net.myapp.exception.MyException;

public class CardNotFoundException extends MyException {
	public CardNotFoundException(String input) {
		this.setErrorDescription("card not found: "+input);
		this.setI18nErrorMessageKey("NOT_FOUND");
	    this.setI18nErrorMessageArg(input);	
	}

}
