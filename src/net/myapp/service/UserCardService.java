package net.myapp.service;

import net.myapp.dao.model.UserCard;
import net.myapp.exception.card.CardNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;
import net.myapp.exception.usercard.UserCardNotActiveException;
import net.myapp.exception.usercard.UserCardNotFoundException;
import net.myapp.exception.usercard.UserCardValidDateExpiredException;
import net.myapp.form.model.CustomerAddRequest;

public interface UserCardService {
  public void add(UserCard userCard);
  public void add(CustomerAddRequest input) throws UserNotValidPinException, CardNotFoundException;
  public UserCard   getUserCard(int userCardID) throws UserCardNotFoundException, UserCardNotActiveException, UserCardValidDateExpiredException;
}
