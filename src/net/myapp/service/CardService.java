package net.myapp.service;

import net.myapp.dao.model.Card;
import net.myapp.hbr.dao.CardTypeDAOImpl;
import net.myapp.model.NextCardInfo;

public interface CardService {
	public NextCardInfo getNextCardInfo(Card card);
	
}
