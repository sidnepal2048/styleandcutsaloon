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
                                </ul>
           
                </div>
            </div>
        </nav>

    </div>
</div>
</nav>
</header>
div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>

            <p class="lead">Please update the product information here:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/Admin/productInventory/editProduct" method="post"
                   commandName="product" >
        <form:hidden path="productId" value="${product.productId}" />

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control" value="${product.productName}"/>
        </div>

         <div class="form-group">
        	    <label for="category">Category</label><form:errors path="productCategory" cssStyle="color: #ff0000;" />
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="hair" />Hair Treatment</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="face" />Face Treatment</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="nail" />Nail Treatment</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label><form:errors path="productDescription" cssStyle="color: #ff0000;" />
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>
        

        <div class="form-group">
            <label for="productUnitInStock">Unit In Stock</label>  <form:errors path="productUnitInStock"
                                                                         cssStyle="color: #ff0000;" />
            <form:input path="productUnitInStock" id="productUnitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="productPrice">Price</label>  <form:errors path="productPrice" cssStyle="color: #ff0000;" />
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/Admin/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>
</div>
</body>
</html>