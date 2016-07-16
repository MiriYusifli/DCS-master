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
 
 <c:forEach items="${User}" var="data">    
 
 <p id="info" style="position:absolute;top:15%;">      
 <spring:message code="p.name"/>: ${data[0].name}
 <br>
 <spring:message code="p.card"/>:${data[6].name}
 <br>
<spring:message code="p.issueDate"/>:${data[1].valid_from}  
 <br>
 <spring:message code="p.lastDate"/>:${data[1].valid_to} 
 <br>
 <spring:message code="p.discount"/>:${data[6].discount}%
<br>
<spring:message code="p.balance"/>: ${data[1].balance}    
<br>
</p>
</c:forEach>


<div class="container" style="position:absolute;top:60%;">
  <h2 align="center"><spring:message code="table.orders"/></h2>
 
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>№</th>
        <th><spring:message code="column.good"/></th>
        <th><spring:message code="column.price"/></th>
        <th><spring:message code="column.discount"/></th>
        <th><spring:message code="column.card"/></th>
        <th><spring:message code="column.date"/></th>
      </tr>
    </thead>
    <tbody>
     <c:set var="count" value="0" scope="page" />
    
     <c:forEach items="${User}" var="data">  
             
             <c:set var="count" value="${count + 1}" scope="page"/>
       
      <tr>
        <td>
		
		<c:out value = "${count}"/>
</td>
        <td>${data[4].name}</td>
        <td>${data[4].price}</td>
        <td>${data[2].total_discount}</td>
        <td>${data[2].userCard.card.cardType.name}</td>
        <td>${data[2].otime}</td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>

	<p id="info" style="position:absolute;top:15%;left:55%">  
	<spring:message code="card.notfication_header"/>
    <spring:message code="${MinusKey}" arguments="${MinusArg}"/>  
    <spring:message code="card.notfication_footer"/>
    <spring:message code="${NameKey}" arguments="${NameArg}"/>  
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
