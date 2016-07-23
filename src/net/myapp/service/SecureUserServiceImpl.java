package net.myapp.service;

import net.myapp.dao.SecureUserDAO;
import net.myapp.dao.model.SecureUser;
import net.myapp.exception.user.UserNotFoundException;

public class SecureUserServiceImpl {
	private SecureUserDAO secureUserDAO;

	public SecureUserDAO getSecureUserDAO() {
		return secureUserDAO;
	}
SecureUser getSecureUser(String login) throws UserNotFoundException  {return secureUserDAO.getSecureUser(login);}
	

}
