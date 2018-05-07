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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
   
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/lib/carousel.css" rel="stylesheet">
  </head>
  <body>

    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
          <li class="nav-item">
               <a class="nav-link" href="home">Home</a> 
              </li>
            <li class="nav-item">
              <a class="nav-link" href="showForm">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login">Sign In</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="product">Product</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="gallery">Photo Gallery</a>
            </li>
            
          </ul>
         </div>
      </nav>
    </header>
    <br>
    <div class="container-wrapper">
    	<div class="container">
    		<div class="page-header">
    			<br><h1></h1>
    	<c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
            </h2>
        </c:if>

    	
    				
    		</div>
    		<h6>
    			<a href="<c:url value="/product"/>">Product Inventory</a>
    			<a href="<c:url value="/email"/>">Email</a>
      			<a href="<c:url value="/RegisterCustomer/Appointment" />">Appointment</a>
    		</h6>
    		
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
    