<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Musteri
                    </a>
                </li>
                <li>
                    <a href="#">Elave et</a>
                </li>
                <li>
                    <a href="#">Axtaris</a>
                </li>
                
            </ul>
        </div>
		
           <div class="section">
		  
      <div class="container">
        <div class="row">
          <div class="col-md-12">
		  <h1 style="position:absolute; left:50%;top:0%;">Axtaris</h1> 
            <form class="form-horizontal" role="form" style="position:absolute; left:10%;top:10000%; width:100%;">
			 
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Pin / Email</label>
                </div>
                <div class="col-sm-4">
                  <input type="text" name="pin_email" value="${Filter.pin_email}" class="form-control" id="inputEmail3"  >
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Kart kodu</label>
                </div>
                <div class="col-sm-4">
                  <input type="text" name="code" value="${Filter.code}"  class="form-control" id="inputPassword3" >
                </div>
              </div>
             
             

			<button type="submit" name="ok"  class="btn btn-default"  style="position:absolute; left:60%;top:0%;">
     			 <span class="glyphicon glyphicon-search"></span> Search
    		</button>
             
              
            </form>
          </div>
        </div>
      </div>
    </div>
    
    
    
    
	   <c:if test="${not empty User}">
	  
	   <form action="">
	     <input type="hidden" id="user_id" value="${User.id}" >
	     <p id="test">${User.name}</p>
         <button type="submit" id="new_order" class="btn btn-default" style="position:absolute; left:40%;top:35%;">Yeni sifaris</button>
	     <button type="submit" id="new_card" class="btn btn-default" style="position:absolute; left:65%;top:35%;">Yeni kart</button>
	     <button type="submit" id="info" class="btn btn-default" style="position:absolute; left:65%;top:45%;">Melumat</button>
	   </form>
	  
	  
	   </c:if>
	   <c:if test="${not empty ErrorKey}">
	 
	  <spring:message code="${ErrorKey}" arguments="${ErrorArg}"/>
	   </c:if>
	   
	   
    
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Musteri</a>
                    
      

    </div>
	
	<!-- <script>
$(document).ready(function(){
    
    	var p=document.getElementById('test').textContent
		if(p.trim()){
            $('#new_card').show();
            $('#new_order').show();
            $('#info').show();

		}

});


</script>
 -->
	
	
	
	
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    
   
    
    </script>

</body>

</html>
