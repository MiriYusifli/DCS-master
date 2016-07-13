package net.myapp.exception.user;


import net.myapp.exception.MyException;


public class UserNotValidPinException extends MyException{

	
public UserNotValidPinException(String input) {
	this.setErrorDescription("user not valid pin: "+input);
}



}
