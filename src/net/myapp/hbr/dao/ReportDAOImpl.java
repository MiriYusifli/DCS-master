package net.myapp.hbr.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.UserCard;
import net.myapp.exception.usercard.UserCardNotActiveException;
import net.myapp.exception.usercard.UserCardNotFoundException;
import net.myapp.exception.usercard.UserCardValidDateExpiredException;


@Repository
public class ReportDAOImpl implements ReportDAO {
private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
	@Transactional
	public List<Object[]> getUserOrders(int userCardID) {
		Session session = this.sessionFactory.getCurrentSession(); 
        
		String hql="select u,uc,o,od,g,c,ct from UserCard uc "
                +" INNER JOIN uc.orderSet as o"
                +" INNER JOIN o.orderDetailSet as od"
                +" INNER JOIN od.good as g"
                +" INNER JOIN uc.card as c"
                +" INNER JOIN c.cardType as ct"
                +" INNER JOIN uc.user  as u"
                +" Where 1=1 AND uc.id= :id";
		
		Query query = session.createQuery(hql);
        query.setInteger("id", userCardID);
		
		
		return query.list();
	}
	
	
	public UserCard getUserCard(int userCardID) throws UserCardNotFoundException, UserCardNotActiveException, UserCardValidDateExpiredException {
		Session session = this.sessionFactory.getCurrentSession(); 
      String hql="select uc,c,ct,u "
				+" FROM UserCard uc "
                +" INNER JOIN uc.card as c"
                +" INNER JOIN c.cardType as ct"
                +" INNER JOIN uc.user  as u"
                +" Where 1=1 AND uc.id= :id";
      
      
      
		
		Query query = session.createQuery(hql);
		query.setInteger("id", userCardID);

		UserCard userCard=null;
		List<UserCard> userCardList=new ArrayList<>();
		List<Object[]> objList=query.list();
        for (Object[] obj: objList ) { userCardList.add((UserCard) obj[0]);}
		if (userCardList.isEmpty())  throw new UserCardNotFoundException(userCardID);
        for (UserCard uc : userCardList) {
			if (uc.getStatus()==1)   {userCard=uc; break;}
		}
        if (userCard==null)  throw new UserCardNotActiveException(userCardID);
		if (userCard.getValid_to().before(new Date()))  throw new UserCardValidDateExpiredException(userCard.getValid_to());
		return userCard;
	}
	
	
	
}
