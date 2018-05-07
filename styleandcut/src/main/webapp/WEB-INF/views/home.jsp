
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
<div >
<p>${msg}</p> 
  </div>  

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1" ></li>
          <li data-target="#myCarousel" data-slide-to="2" ></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="first-slide" src="<c:url value="/resources/images/sandy.jpg"/>" alt="First slide">
            
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="<c:url value="/resources/images/sandhya.jpg"/>" alt="Second slide">
            
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="<c:url value="/resources/images/kopu.jpg"/>" alt="Third slide">
            
          </div>
       
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
     


      
      <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4">
            <img class="rounded-circle" src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Generic placeholder image" width="140" height="140">
            <h2>Welcome</h2>
            <p>Welcome to the StyleAndCutSaloon. We provide various services like hair cut for both men and women, beauti tips and products etc.</p>
            <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
     </div>
      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"></p>
        <p>&copy; 2017-2018 Company, Inc. &middot;</p>
      </footer>
    

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