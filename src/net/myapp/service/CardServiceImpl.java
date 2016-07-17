package net.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.common.web.holders.RequestHelper;
import net.myapp.dao.model.Card;
import net.myapp.dao.model.CardType;
import net.myapp.hbr.dao.CardDAOImpl;
import net.myapp.hbr.dao.CardTypeDAOImpl;
import net.myapp.helper.card.CardTypeUtil;
import net.myapp.model.NextCardInfo;


@Service
public class CardServiceImpl implements CardService {
	
	private CardTypeDAOImpl cardTypeDAO;
	


	public void setCardTypeDAO(CardTypeDAOImpl cardTypeDAO) {
		this.cardTypeDAO = cardTypeDAO;
	}

	
	@Transactional
	public NextCardInfo  getNextCardInfo(Card card,CardTypeDAOImpl cardTypeDAOImpl){
		
		/*double balance=card.getUserCard().getBalance();
		int cardType_id=card.getCardType().getId();
		CardNotifications cardNotifications=new CardNotifications();
		
		
		
		String nextCardName=cardTypeDAO.getByType(cardType_id).getName();
		double required_balance=cardTypeDAO.getByType(cardType_id).getPassing_amount()-balance;
		if(cardType_id<cardTypeDAO.getTopCardType().getId())
		{
		nextCardName=cardTypeDAO.getByType(cardType_id+1).getName();
		}
		cardNotifications.PassNextCardName(nextCardName);
		RequestHelper.setAttribute("NameKey", cardNotifications.geti18nNotfMessageKey());
		RequestHelper.setAttribute("NameArg", cardNotifications.geti18nNotfMessageArg());
		cardNotifications.PassNextCardBalanceMinus(String.valueOf(required_balance));
		RequestHelper.setAttribute("MinusKey", cardNotifications.geti18nNotfMessageKey());
		RequestHelper.setAttribute("MinusArg", cardNotifications.geti18nNotfMessageArg());
		*/
		CardTypeUtil cardTypeUtil=new CardTypeUtil(cardTypeDAOImpl);
		CardType cardType=cardTypeUtil.getNextCardType(card.getCardType());
		double needableAmountForPassing=card.getUserCard().getCard().getCardType().getPassing_amount()-card.getUserCard().getBalance();
		//System.out.println();
		NextCardInfo nextCard=new NextCardInfo(cardType.getName(),needableAmountForPassing );
		return nextCard;
		
		
	}


	
	
	
	
	
}
