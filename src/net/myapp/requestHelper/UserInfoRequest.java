package net.myapp.requestHelper;

import java.util.List;

import net.myapp.dao.model.CardType;
import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;
import net.myapp.model.UserInfo;

public class UserInfoRequest {
	public static UserInfo UserMainInfo(List<Object[]> usercardList){
		UserInfo userInfo=new UserInfo();
		User user=(User)usercardList.get(0)[0];
		UserCard userCard=(UserCard)usercardList.get(0)[1];
		CardType cardType=(CardType)usercardList.get(0)[6];

		userInfo.setName(user.getName());
		userInfo.setCardType_name(cardType.getName());
		userInfo.setIssueDate(userCard.getValid_from());
		userInfo.setLastDate(userCard.getValid_to());
		userInfo.setDiscount(cardType.getDiscount());
		userInfo.setBalance(userCard.getBalance());
		
		
		
		
		return userInfo;
	}
	
	
}
