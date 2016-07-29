<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		  <h1 style="position:absolute; left:50%;top:0%;">Yeni sifaris</h1> 
		  <h3  style="position:absolute; left:10%;top:7000%;">Istifadeci:${Usercard.user.surname}  ${Usercard.user.name}</h3>
          <h3  style="position:absolute; left:10%;top:10000%;">Kard kodu:${Usercard.card.code}</h3>
          
            
            <form class="form-inline" role="form" style="position:absolute; left:10%;top:20000%; width:100%;">
			 
            
             <div class="form-group">
      <div class="col-xs-2">
        <label for="ex1">Mehsul</label>
        <input class="form-control" id="good" type="text"  name="good_id">
        
      </div></div>
      
      <div class="form-group">
      <div class="col-xs-2">
        <label for="ex1">Sayi</label>
        <input class="form-control" id="gcount" type="text"  name="gcount">
        
      </div></div>
      
      <div class="form-group">
      <div class="col-xs-2">
        <label for="ex1">Qiymeti</label>
        <input class="form-control" id="price" type="text"  name="price">
        
      </div></div>
	
		<input type="hidden" value="${Usercard.id}" name="userCard_id">
	
		   <button type="button" class="btn btn-default" id="add"  style="position:absolute; left:75%;top:45%;">Elave et</button>
			   <button type="button" class="btn btn-default" id="ok" value="add" name="ok" style="position:absolute; left:75%;top:125%;">Bitir</button>
	
			
              
            </form>
             <form class="form-inline" role="form" style="position:absolute; left:10%;top:29000%; width:100%;">
			 
            
            <label class="radio-inline">
      <input type="radio" name="optradio" checked >Option 1
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">Option 2
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">Option 3
    </label>
              
            </form>
            
            <table class="table table-bordered" id="myTable" style="position:absolute; left:10%;top:35000%;"> 
    <thead>
      <tr>
        <th>Good</th>
        <th>Count</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody>
     
      
    </tbody>
  </table>
            
          </div>
          
          
        </div>
        
      </div>
  
 
</div>
      
      
	   
	   
	   
    
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Musteri</a>
                    
      

    </div>
	<!-- as -->
	
	
	
	
<script>
var orders = [
                
                
                
             ];
             
$(document).ready(function(){
    $("#add").click(function(){
    	

    	var good = document.getElementById("good").value;
    	var count = document.getElementById("gcount").value;
    	var price = document.getElementById("price").value;
   	 orders.push({"name":good,"count":count,"price":price});

    	
    	var table = document.getElementById("myTable");
    	var rows = table.getElementsByTagName("tr")
    	  
 	    var row = table.insertRow(rows.length);
 	    var cell0 = row.insertCell(0);
 	    var cell1 = row.insertCell(1);
 	    var cell2 = row.insertCell(2);
 	    var cell3 = row.insertCell(3);

 	    
			
 	    cell0.innerHTML =orders[orders.length-1].name;
 	    cell1.innerHTML =orders[orders.length-1].count;;
 	    cell2.innerHTML =orders[orders.length-1].price;;
 	    cell3.innerHTML ="<button type='button' id="+(rows.length-1)+" onclick='Delete(this.parentNode.parentNode.rowIndex)'>Sil</button>";


    });
});


$(document).ready(function(){
    $("#ok").click(function(){
$.ajax({
	type: 'POST',
	dataType: 'json',
	headers: {
		Accept:"application/json; charset=utf-8",
		"Content-Type":"application/json; charset=utf-8"
	},
	
	url: "create_persons",
	data:JSON.stringify(orders),
	success: function(data, textStatus ){
	console.log(data);
	//alert("success");
	},
	error: function(xhr, textStatus, errorThrown){
	//alert('request failed'+errorThrown);
	}
	});
    });
});




function Delete(i) {
    document.getElementById('myTable').deleteRow(i)
	orders.splice(i-1,1);
   
}

</script>

	
	
	<!-- as -->
	
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
