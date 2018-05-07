<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Style and cut</title>

    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" > </script>

    <%--Jquery--%>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/lib/bootstrap.min.css" rel="stylesheet">
    
    <!-- Carousel CSS -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

    

</head>
<!-- NAVBAR
================================================== -->
<body>
<header class="clearfix">
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                   <ul class="navbar-nav mr-auto">
 	         <li><a href="<c:url value="/" /> ">Home</a></li>
             <li><a href="<c:url value="/product/productList" />">Products</a></li>
             <li><a href="<c:url value="/about" />">About Us</a></li>
          </ul>
                    
                </div>
            </div>
        </nav>

    </div>
</div>
</nav>
</header>
   		<div class="container-wrapper">
    <div class="container" style="position: absolute">
        <div class="page-header">
            <h1>Register Employee</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/Admin/stylist" name="form" method="post"
                   commandName="stylist">

        <h3>Basic Info</h3>

        <div class="form-group">
            <label for="stylistName">Name</label><form:errors path="stylistName" cssStyle="color: #ff0000"/>
            <form:input path="stylistName" id="stylistName"  class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Email</label><form:errors
                path="username" cssStyle="color: #ff0000"/>
            <form:input path="username" id="username"  class="form-Control"/>
            <span style="color: #ff0000">${usernameMsg}</span>
        </div>

        <div class="form-group">
            <label for="stylistPassword">Password</label><form:errors path="stylistPassword" cssStyle="color: #ff0000"/>
            <form:password path="stylistPassword"   id="stylistPassword" class="form-Control"/>
        </div>

		<input type="submit" value="submit" id="button" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
	</form:form>
	</div>
	</div>
        		
</body>
</html>