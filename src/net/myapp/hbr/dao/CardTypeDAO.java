package net.myapp.hbr.dao;

import net.myapp.dao.model.CardType;

public interface CardTypeDAO {
	public CardType getByType(int type_id);
}
