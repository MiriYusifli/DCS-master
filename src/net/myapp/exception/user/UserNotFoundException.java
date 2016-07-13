package net.myapp.exception.user;


import net.myapp.exception.MyException;


public class UserNotFoundException extends MyException{

//private static final long serialVersionUID = 8113746196212907523L;
public UserNotFoundException(String input) {
	this.setErrorDescription("user not found: "+input);
	this.setI18nErrorMessageKey("NOT_FOUND");
    this.setI18nErrorMessageArg(input);	
}



}
