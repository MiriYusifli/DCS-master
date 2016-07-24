package net.myapp.exception.usercard;

import net.myapp.exception.MyException;

public class UserCardNotFoundException extends MyException {
	public UserCardNotFoundException(Object input) {
		this.setErrorDescription("user card not found: "+input);
		this.setI18nErrorMessageKey("NOT_ACTIVE");
	    this.setI18nErrorMessageArg(input);	
	}
}
