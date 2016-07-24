package net.myapp.hbr.dao;

import java.util.List;

import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;

public interface UserDAO {
	public void add(User p);
	public User getById(int id);
	public List<Object[]> getTest(UserCard card) throws UserNotFoundException, UserNotValidPinException ;
	public List<User> listPersons();
	public void update(User p); 
			   
}
