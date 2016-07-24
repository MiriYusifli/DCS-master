package net.myapp.hbr.dao;

import java.util.List;

import net.myapp.dao.model.UserCard;
import net.myapp.exception.usercard.UserCardNotActiveException;
import net.myapp.exception.usercard.UserCardNotFoundException;
import net.myapp.exception.usercard.UserCardValidDateExpiredException;

public interface ReportDAO {
	public List<Object[]> getUserOrders(int userCardID);
	public UserCard getUserCard(int userCardID) throws UserCardNotFoundException, UserCardNotActiveException, UserCardValidDateExpiredException;
	
}
