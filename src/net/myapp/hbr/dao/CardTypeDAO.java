package net.myapp.hbr.dao;

import java.util.List;

import net.myapp.dao.model.Card;
import net.myapp.dao.model.CardType;

public interface CardTypeDAO {
	public CardType getTopCardType();
	 public List<CardType> getAllCardType();
	 public CardType getByType(int type_id);
}
