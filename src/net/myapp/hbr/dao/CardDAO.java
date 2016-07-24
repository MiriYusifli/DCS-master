package net.myapp.hbr.dao;

import net.myapp.dao.model.Card;

public interface CardDAO {
	 public void add(Card p);
	 public void update(Card p);
	 public Card getById(int id);
	 public Card getByCode(String code);
}
