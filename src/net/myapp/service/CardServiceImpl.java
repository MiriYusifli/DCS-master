package net.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.common.web.holders.RequestHelper;
import net.myapp.dao.model.Card;
import net.myapp.dao.model.CardType;
import net.myapp.dao.model.UserCard;
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
	public NextCardInfo  getNextCardInfo(UserCard userCard){
		CardTypeUtil cardTypeUtil=new CardTypeUtil(cardTypeDAO);
		CardType cardType=cardTypeUtil.getNextCardType(userCard.getCard().getCardType());
		double needableAmountForPassing=userCard.getCard().getUserCard().getCard().getCardType().getPassing_amount()-userCard.getCard().getUserCard().getBalance();
		//System.out.println();
		NextCardInfo nextCard=new NextCardInfo(cardType.getName(),needableAmountForPassing );
		return nextCard;
		
		
	}


	
	
	
	
	
}
