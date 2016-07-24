package net.myapp.test.spring.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;
import net.myapp.common.web.holders.WebAuthHelper;
import net.myapp.common.web.holders.WebSessionHelper;
import net.myapp.dao.SecureUserDAO;
import net.myapp.dao.SecureUserDAOImpl;
import net.myapp.dao.model.Card;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.card.CardNotFoundException;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.exception.user.UserNotValidPinException;
import net.myapp.exception.usercard.UserCardNotActiveException;
import net.myapp.exception.usercard.UserCardNotFoundException;
import net.myapp.exception.usercard.UserCardValidDateExpiredException;
import net.myapp.form.model.CardSearchRequest;
import net.myapp.form.model.CustomerAddRequest;
import net.myapp.hbr.dao.CardDAO;
import net.myapp.hbr.dao.CardDAOImpl;
import net.myapp.hbr.dao.CardTypeDAO;
import net.myapp.hbr.dao.CardTypeDAOImpl;
import net.myapp.hbr.dao.ReportDAO;
import net.myapp.hbr.dao.ReportDAOImpl;
import net.myapp.hbr.dao.UserCardDAO;
import net.myapp.hbr.dao.UserCardDAOImpl;
import net.myapp.hbr.dao.UserDAO;
import net.myapp.hbr.dao.UserDAOImpl;
import net.myapp.helper.CommonUtil;
import net.myapp.helper.SecureUserUtil;
import net.myapp.helper.secure.Utils;
import net.myapp.service.CardService;
import net.myapp.service.UserCardService;
import net.myapp.service.UserCardServiceImpl;
@Controller

public class SecurePanelController {
	@Autowired
	private MessageSource messageSource;
	
	
	@Autowired(required = true)
	@Qualifier(value = "secureUserDAO")
	private SecureUserDAO secureUserDAO;

    @Autowired(required = true)
	@Qualifier(value = "userDAO")
	private UserDAO userDAO;
    
	@Autowired(required = true)
	@Qualifier(value = "reportDAO")
	private ReportDAO reportDAO;

    /*
	@Autowired(required = true)
	@Qualifier(value = "cardDAO")
	private CardDAO cardDAO;
	
	
	@Autowired(required = true)
	@Qualifier(value = "cardTypeDAO")
	private CardTypeDAO cardTypeDAO;
	
	@Autowired(required = true)
	@Qualifier(value = "userCardDAO")
	private UserCardDAO userCardDAO;
	
*/
	
	
	
	
	@Autowired
	@Qualifier(value = "userCardService")
	private UserCardService userCardService;
	
	
	@Autowired(required = true)
	@Qualifier(value = "cardService")
	private CardService cardService;
	
	
	//// normal page passing to default/jsp folder page inside of main.jsp
	@RequestMapping(value = "panel/login", method = RequestMethod.GET)
	public String printHello(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {

		System.out.println(login);
		if (!CommonUtil.isNullOrEmpty(login)) {
			Log.debug("login : " + login);
			SecureUser secureUser;
			try {
				secureUser = secureUserDAO.getSecureUser(login);

				System.out.println(Utils.getMD5(pass));
				if (secureUser.getPass().equals(Utils.getMD5(pass))) {
					Log.debug("succesfully logined ");
					WebAuthHelper.setAuthenticatedSecureUser(secureUser);

				}
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				RequestHelper.setAttribute("ErrorKey", e1.getI18nErrorMessageKey());
				RequestHelper.setAttribute("ErrorArg", e1.getI18nErrorMessageArg());
				System.out.println(e1.getI18nErrorMessageArg());
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (SecureUserUtil.isAdmin())
			return "redirect:/admin/first";
		else if (SecureUserUtil.isSeller())
			return "redirect:/seller/first";
		return "login";
	}

	@RequestMapping(value = "panel/logout", method = RequestMethod.GET)
	public String printHello1() {
		WebSessionHelper.clearSessionData();
		return "login";
	}
		
	@RequestMapping(value = "card/search", method = RequestMethod.GET)
	public String index_CardSearch(CardSearchRequest input) {
	UserCard userCard=new UserCard();
	User user=new User();
	Card card=new Card();
	if(input.isNotNullSubmitOk()) {
	  if(CommonUtil.isEmail(input.getPin_email())) 	user.setEmail(input.getPin_email());
	  else                                          user.setPin(input.getPin_email());
	card.setCode(input.getCode());
	
	//test ucun id e 1 atiram ki int oldugu ucun error cixir
	//userCard.setId(1);
	userCard.setUser(user);
	userCard.setCard(card);
	
	try {
		List<Object[]> usercardList = userDAO.getTest(userCard);
		User foundUser=(User) usercardList.get(0)[0];
		RequestHelper.setAttribute("User",foundUser);
		
	} catch (UserNotFoundException e) {
		e.addErrorKeyArgToRequestHelper();
		e.printStackTrace();
	} catch (UserNotValidPinException e) {
		//we dont worry about info to user interface , only in log print exception
		e.printStackTrace();
	}
	}
	
	
	RequestHelper.setAttribute("Filter", input);
	return "CardSearch";
	}
	
	
	@RequestMapping(value = "customer/add", method = RequestMethod.GET)
	public String page_customer_add(CustomerAddRequest input) {
		if(input.isNotNullSubmitOk()) {try {
			userCardService.add(input);
		} catch (UserNotValidPinException | CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	return "CustomerAdd";
	}
	
	

	@RequestMapping(value = "user/info", method = RequestMethod.GET)
	public String page_user_info(int id) {//burda  adi string goturek  user_card_id onda atdaki line silinecek
			UserCard userCard;
			try {
				userCard = userCardService.getUserCard(id);
				RequestHelper.setAttribute("UserCard",userCard);
				RequestHelper.setAttribute("Orders", reportDAO.getUserOrders(id));
				RequestHelper.setAttribute("NextCardInfo",cardService.getNextCardInfo(userCard));
				
			} catch (UserCardNotFoundException | UserCardNotActiveException | UserCardValidDateExpiredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//e.addErrorKeyArgToRequestHelper();
			}
			
	return "UserInfo";
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	@RequestMapping(value = "new_order", method = RequestMethod.GET)
	public String printHello7(@RequestParam(defaultValue = "null") String user_id) {
	User user=new User();
		
		
	return "new_order";
	}
	//branch m_11_07
	@RequestMapping(value = "new_card", method = RequestMethod.GET)
	public String printHello8(@RequestParam(defaultValue = "null") String user_id) {
	
	return "new_card";
	}
	
	
	
}
