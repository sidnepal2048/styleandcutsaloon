<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="Siddhartha" content="">
    
    <title>StyleAndCutSalon</title>

    <!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/lib/bootstrap.min.css" />" rel="stylesheet">  
	<link href="<c:url value="/resources/css/lib/carousel.css" />" rel="stylesheet">  
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	 </head>
  <body>

    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
 	         <li><a href="<c:url value="/" /> ">Home</a></li>
             <li><a href="<c:url value="/product/productList" />">Products</a></li>
             <li><a href="<c:url value="/about" />">About Us</a></li>
          </ul>
         <ul class="nav navbar-nav pull-right">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name != 'siddharthanepal05@gmail.com'}">
                                <li><a href="<c:url value="/shopping/cart" />">Cart</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name  == 'siddharthanepal05@gmail.com'}">
                                <li><a href="<c:url value="/Admin" />">Admin</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name  == null}">
                        	<a href="<c:url value="/login/" />">Login</a>
                        	<a href="<c:url value="/RegisterCustomer/register" />">Register</a>
                        </c:if>
                    </ul>
           
        </div>
      </nav>
    </header>
<div class="container-wrapper">
    	<div class="container">
    		<div class="page-header">
    				<p class="lead">Appointment List</p>
    		
    			<table class="table table-striped table-hover">
           
            <thead>
            <tr class="bg-success">
                <th>Appointment ID</th>
                <th>Customer Name</th>
                <th>Stylist Name</th>
                <th>Date Time</th>
                </tr>
            </thead>
            <c:forEach items="${appointmentList}" var="appointmentList">
                <tr>
                    
                    <td>${appointmentList.appointmentId}</td>
                    <td>${appointmentList.customer.customerName}</td>
                    <td>${appointmentList.stylist.stylistName}
                    <td>${appointmentList.date}</td>
                     
                      </tr>
            </c:forEach>
        </table>
       
				
    		</div>
    		<!-- FOOTER -->
     		 <footer class="container">
        	<p class="float-right"></p>
        	<p>&copy; 2017-2018 Company, Inc. &middot;</p>
      </footer>	
    	</div> 	
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/css/lib/bootstrap.min.css"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
   
  </body>
</html>
    