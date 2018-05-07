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
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/lib/carousel.css" rel="stylesheet">
  </head>
  <body>
    <div class="container-wrapper">
    	<div class="container">
    		<div class="page-header">
    			<br><h1></h1>
    			<p class="lead">List of All Products</p>	
    		</div>
	 <form:form action="${pageContext.request.contextPath}/Admin/productInventory/addProduct" method="post"
                   modelAttribute="product"  >
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="productName" cssStyle="color: #ff0000;" />
            <form:input path="productName" id="name" class="form-Control"/>
        </div>
   <a href="<c:url value="/Admin/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>
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
    
  