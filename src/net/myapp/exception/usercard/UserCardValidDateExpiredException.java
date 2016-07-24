package net.myapp.exception.usercard;

import net.myapp.exception.MyException;

public class UserCardValidDateExpiredException extends MyException {
	public UserCardValidDateExpiredException(Object input) {
		this.setErrorDescription("user card valid date expired: "+input);
		this.setI18nErrorMessageKey("NOT_ACTIVE");
	    this.setI18nErrorMessageArg(input);	
	}
}
