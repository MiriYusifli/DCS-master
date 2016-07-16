package net.myapp.service;

import net.myapp.dao.model.UserCard;
import net.myapp.exception.card.CardNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;
import net.myapp.form.model.CustomerAddRequest;

public interface UserCardService {
  public void add(UserCard userCard);
  public void add(CustomerAddRequest input) throws UserNotValidPinException, CardNotFoundException;
  
}
