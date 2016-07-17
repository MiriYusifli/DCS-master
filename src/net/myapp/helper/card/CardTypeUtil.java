package net.myapp.helper.card;

import java.util.List;

import net.myapp.dao.model.CardType;
import net.myapp.hbr.dao.CardTypeDAOImpl;

public class CardTypeUtil {

	List<CardType> cardTypeList;

	
	
	
	public CardTypeUtil(CardTypeDAOImpl cardTypeDAOImpl) {
		super();
		cardTypeList=cardTypeDAOImpl.getAllCardType();
	}

	public List<CardType> getCardTypeList() {
		return cardTypeList;
	}

	public void setCardTypeList(List<CardType> cardTypeList) {
		this.cardTypeList = cardTypeList;
	}
	
	
	
	public CardType getNextCardType(CardType cardType){
		//if that is high card type then retunr this cardType
		if (cardTypeList.size()==cardType.getId())  return cardTypeList.get(cardType.getId()-1);
		return cardTypeList.get(cardType.getId());
	}
	
	
	
}
