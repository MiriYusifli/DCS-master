package net.myapp.hbr.dao;

import net.myapp.dao.model.UserCard;

public interface UserCardDAO {
	 public void add(UserCard p);
	 public void update(UserCard p);
	 public UserCard getById(int id);
	
}
