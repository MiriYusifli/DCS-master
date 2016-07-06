<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">


<%@ page isELIgnored="false"%>
	<head>
		<title>Hello World with Spring 3 MVC</title>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
	</head>
	<body>

	
	Balance: ${UserCard.balance}<br/>
    Card code:${UserCard.card.code}<br/>
    Card type name:${UserCard.card.cardType.name}<br/>
   

    <c:forEach items="${Report}" var="data">

       userCard.balance-----${data[1].balance}<br>
       order.date---------${data[2].odate}"<br>
       orderDetail.gcount---------${data[3].gcount}<br>
       good.name---------${data[4].name}<br>
       card.code---------${data[5].code}<br>
       cardType.name---------${data[6].name}<br>

</c:forEach>



	</body>
</html>