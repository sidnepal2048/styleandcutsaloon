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
                        	<a href="<c:url value="/customer/register" />">Register</a>
                        </c:if>
                    </ul>
         
        </div>
      </nav>
    </header>
 <div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
                <a href="<spring:url value="/RegisterCustomer/checkout"/>"
                   class="btn btn-success pull-right"><span class="glyphicon-shopping-cart glyphicon"></span> Check out
                </a>
            </div>
           
            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Product</th>
                    </tr>
                
                <tr> 
              
                    <td>${name}</td>
                    <td>${price}</td>
                    <td>${quant}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span>remove</a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
                
            </table>

            <a href="<spring:url value="/" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>

    </div>
</div>
		    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" > </script>
	<script src="<c:url value="/resources/js/lib/controller.js"/>"></script>
	</body>
</html>
		