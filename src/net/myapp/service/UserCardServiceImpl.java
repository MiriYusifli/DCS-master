package net.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.CardType;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.card.CardNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;
import net.myapp.exception.usercard.UserCardNotActiveException;
import net.myapp.exception.usercard.UserCardNotFoundException;
import net.myapp.exception.usercard.UserCardValidDateExpiredException;
import net.myapp.form.model.CustomerAddRequest;
import net.myapp.form.model.PayOrdersRequest;
import net.myapp.hbr.dao.CardDAO;
import net.myapp.hbr.dao.CardDAOImpl;
import net.myapp.hbr.dao.ReportDAO;
import net.myapp.hbr.dao.ReportDAOImpl;
import net.myapp.hbr.dao.UserCardDAO;
import net.myapp.hbr.dao.UserCardDAOImpl;
import net.myapp.hbr.dao.UserDAO;
import net.myapp.hbr.dao.UserDAOImpl;
import net.myapp.helper.DateUtil;
import net.myapp.validity.user.UserValidity;

@Service
public class UserCardServiceImpl implements UserCardService{

	private UserDAO userDAO;
	private UserCardDAO userCardDAO;
	private CardDAO cardDAO;
	private ReportDAO reportDAO;
	
	
	


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setUserCardDAO(UserCardDAO userCardDAO) {
		this.userCardDAO = userCardDAO;
	}

	public void setCardDAO(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}

	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	@Override
	@Transactional
	public void add(UserCard userCard) {
		userDAO.add(userCard.getUser());
		userCardDAO.add(userCard);
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
	public UserCard getUserCard(int userCardID) throws UserCardNotFoundException, UserCardNotActiveException, UserCardValidDateExpiredException {
		return reportDAO.getUserCard(userCardID);
	}

	@Override
	public UserCard payOrders(PayOrdersRequest payOrdersRequest,double c) {
		// c musterinin depozitden ne qeder istifade etmek istediyini gosterir
		UserCard userCard=payOrdersRequest.getUserCard();
		double discount=userCard.getDiscount();
		double payment_price=payOrdersRequest.getPayment_price();
		switch (payOrdersRequest.getPayment_option()) {
		
		case 1:discount=discount+payOrdersRequest.getPayment_discount();
			  
			break;
		case 2:payment_price=payment_price-payOrdersRequest.getPayment_discount();
				
			break;
		case 3:payment_price=payment_price-payOrdersRequest.getPayment_discount()-c;
				discount=discount-c;
	
			break;

		default:
			break;
		}
		userCard.setBalance(userCard.getBalance()-payment_price);
		userCard.setDiscount(discount);
		 
		userCardDAO.update(userCard);
		
		return userCard;
		}
		
	}
	
	
		
		
		
	


