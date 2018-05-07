<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="Siddhartha" content="">
    
    <title>StyleAndCutSalon</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/lib/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/lib/carousel.css" rel="stylesheet">
	  
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
          </div>
      </nav>
    </header>
    <div class="container-wrapper">
    	<div class="container">
    		<div class="page-header">
    				<p class="lead">Customer List</p>
    		<form:form action="${pageContext.request.contextPath}/Admin/customers" method="post">
    
    			<table class="table table-striped table-hover">
           
            <thead>
            <tr class="bg-success">
                <th>Customer Name</th>
                <th>Username</th>
                <th>Active</th>
                </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    
                    <td>${customer.customerName}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                    
                </tr>
            </c:forEach>
        </table>
       
	</form:form>    			
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
    