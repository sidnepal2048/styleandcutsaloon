
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
  </div>
      </nav>
    </header>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!        System.out.println(path);
            </p>
        </div>

        <div class="container" data-ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                             style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <h4>${product.productPrice} USD</h4>

                    <br>

                    <c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/product/productList" />
                    <c:if test="${role='siddharthanepal05@gmail.com'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p data-ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <button data-ng-click="addToCart('${product.productId}')">Order Now</button>
                        
                       <!--   <a href="#" class="btn btn-warning btn-large" data-ng-click="addToCart('${product.productId}')">
                           <span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a> -->
                        <a href="<spring:url value="/shopping/cart" />"
                           class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" > </script>   
   <script src="<c:url value="/resources/js/lib/controller.js" /> "></script>
	
    </body>
    
   </html>