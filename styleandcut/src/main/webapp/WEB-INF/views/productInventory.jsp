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
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/lib/carousel.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/js/lib/bootstrap.min.js" >
    <link href="${pageContext.request.contextPath}/resources/js/lib/jquery-1.11.3.min.js">
    
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
    			<br><h1>Product Inventory</h1>
    			<p class="lead">Product List</p>
    			<a href="<spring:url value="/Admin/productInventory/addProduct" />">Add Product</a>
    
    			<table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Description</th>
                <th>Stock</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="#" alt="image"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productUnitInStock}</td>
                    <td>${product.productPrice} USD</td>
                    
                    
                    <td><a href="<spring:url value="/Admin/productInventory/deleteProduct/${product.productId}" />">
                        <span class="fa fa-trash"></span></a> 
                         <a href="<spring:url value="/Admin/productInventory/editProduct/${product.productId}" />"
                        ><span class="fa fa-pencil"></span></a>
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
    