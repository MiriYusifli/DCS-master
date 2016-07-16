package net.myapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.CardType;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.card.CardNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;
import net.myapp.form.model.CustomerAddRequest;
import net.myapp.hbr.dao.CardDAOImpl;
import net.myapp.hbr.dao.UserCardDAOImpl;
import net.myapp.hbr.dao.UserDAOImpl;
import net.myapp.helper.DateUtil;
import net.myapp.validity.user.UserValidity;

@Service
public class UserCardServiceImpl implements UserCardService{

	
	private UserDAOImpl userDAO;
	private UserCardDAOImpl userCardDAO;
	private CardDAOImpl cardDAO;

	public void setUserDAO(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}

	public void setUserCardDAO(UserCardDAOImpl userCardDAO) {
		this.userCardDAO = userCardDAO;
	}

	public void setCardDAO(CardDAOImpl cardDAO) {
		this.cardDAO = cardDAO;
	}

	@Override
	@Transactional
	public void add(UserCard userCard) {
		userDAO.add(userCard.getUser());
		userCardDAO.add(userCard);
	}

	@Override
	public void add(CustomerAddRequest input) throws UserNotValidPinException, CardNotFoundException {
		
		
		UserCard userCard=new UserCard();
		userCard.setBalance(0);
		userCard.setDiscount(0);
		//active status 
		userCard.setStatus(1);
		userCard.setValid_from(DateUtil.getCurrentDateAndTime());
		//60 we must get from DB
		userCard.setValid_to(DateUtil.addMonth(60));

        //we must get card with type and define card type if type not Standart then exception 
		userCard.setCard(cardDAO.getByCode(input.getCardCode()));
		if (userCard.getCard()==null)  throw new CardNotFoundException(input.getCardCode());
                                    //CardTypeNotSuitableException

		User user=new User();
		user.setName(input.getName());
		user.setSurname(input.getSurname());
		user.setGender(input.getGender());
		//we must check have this email in DB
		user.setEmail(input.getEmail());
		user.setPhone(input.getPhone());
		user.setPhonework(input.getPhonework());
		user.setSpecialty(input.getSpecialty());
		user.setCity(input.getCity());
		//we must check that is unique in DB
		if (!UserValidity.checkPin(input.getPin()))  throw new UserNotValidPinException(input.getPin());
		user.setPin(input.getPin());
		//set email as a default for first time
		user.setPass(input.getEmail());
		userCard.setUser(user);

		//change from session
		SecureUser seller=new SecureUser();
		seller.setName("Ayxan");
		seller.setId(2);
		userCard.setSeller(seller);
				
		this.add(userCard);
		
		
	}
	
	
		
		
		
	

}
