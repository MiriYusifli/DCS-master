package net.myapp.service;

import net.myapp.dao.model.UserCard;
import net.myapp.model.NextCardInfo;

public interface CardService {
	public NextCardInfo getNextCardInfo(UserCard userCard);
	
}
