package net.myapp.exception.user;


import net.myapp.exception.MyException;


public class UserNotFoundException extends MyException{

	
public UserNotFoundException(String login) {
	this.setErrorDescription("user not found: "+login);
	this.setI18nErrorMessageKey("NOT_FOUND");
    this.setI18nErrorMessageArg(login);	
}
@Override
public String getMessage() {
	return this.getErrorDescription();
}


}
