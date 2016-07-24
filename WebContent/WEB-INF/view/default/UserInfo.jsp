<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/simple-sidebar.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

		  <h1 style="position:absolute; left:50%;top:0%;">
		  <spring:message code="title.account"/>
	     </h1> 
    
 
 <p id="info" style="position:absolute;top:15%;">      
 <spring:message code="user.name"/>: ${UserCard.user.name}
 <br>
 <spring:message code="cardType"/>:${UserCard.card.cardType.name}
 <br>
<spring:message code="validFrom"/>:${UserCard.valid_from}  
 <br>
 <spring:message code="validTo"/>:${UserCard.valid_to} 
 <br>
 <spring:message code="discount"/>:${UserCard.discount}%
<br>
<spring:message code="balance"/>: ${UserCard.balance}    
<br>
</p>



<div class="container" style="position:absolute;top:60%;">
  <h2 align="center"><spring:message code="table.orders"/></h2>
 
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>№</th>
        <th><spring:message code="good"/></th>
        <th><spring:message code="price"/></th>
        <th><spring:message code="discount"/></th>
        <th><spring:message code="cardType"/></th>
        <th><spring:message code="date"/></th>
      </tr>
    </thead>
    <tbody>
     <c:set var="count" value="0" scope="page" />
    
     <c:forEach items="${Orders}" var="data">  
             
             <c:set var="count" value="${count + 1}" scope="page"/>
       
      <tr>
        <td>
		
		<c:out value = "${count}"/>
</td>
        <td>${data[4].name}</td>
        <td>${data[4].price}</td>
        <td>xxxx</td>
        <td>${data[6].name}</td>
        <td>${data[2].odate}</td>
       </tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>

	<p id="info" style="position:absolute;top:15%;left:55%">
	
	<c:if test="${not NextCardInfo.canGetNewCard}">  
	<spring:message code="nextCardInfo" arguments="${NextCardInfo.needableAmountForPassing},${NextCardInfo.name}"/> 
	</c:if> 
	<c:if test="${NextCardInfo.canGetNewCard}">  
	<spring:message code="canGetNewCard" arguments="${NextCardInfo.name}"/> 
	</c:if> 
     <p>
    
    
    
    
    
    
	   
	   
	
	
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    
</body>


<style>
#info {
font-size: 150%;
}

</style>
    
</html>
