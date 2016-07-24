package net.myapp.exception.usercard;

import net.myapp.exception.MyException;

public class UserCardNotActiveException extends MyException {
	public UserCardNotActiveException(Object input) {
		this.setErrorDescription("user card not active: "+input);
		this.setI18nErrorMessageKey("VALID_DATE_EXPIRED");
	    this.setI18nErrorMessageArg(input);	
	}
}
