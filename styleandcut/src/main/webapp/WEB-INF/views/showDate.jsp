<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Appointment</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/lib/bootstrap.min.css" />" rel="stylesheet">  
	<link href="<c:url value="/resources/css/lib/carousel.css" />" rel="stylesheet">  
	
   
        <link href="<c:url value="/resources/dateTime/jquery.datetimepicker.css" />" rel="stylesheet">  
         <script src="${pageContext.request.contextPath}/resources/dateTime/jquery.js"></script>
	     <script src="${pageContext.request.contextPath}/resources/dateTime/jquery.datetimepicker.full.min.js"></script>
		<script>
			$(function(){
				jQuery('#datetimepicker').datetimepicker({
					timepicker:true,
					 formatDate:'Y/m/d',
					 minDate:'0',
					//yesterday is minimum date(for today use 0 or -1970/01/01)
					 maxDate:'+1970/01/06',//maximum date calendar
					 minTime:'0'
				     
				     
					});
				});
		</script>
 
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
    
        <p>${msg}</p>
         <form:form action="${pageContext.request.contextPath}/RegisterCustomer/pickAvailableStylist" commandName="stylist"  method="post">
      
        
              
            <label for="datepicker">Choose Date:</label>
            <input type="text" name="dob" id="datetimepicker">
            
			            
            <input type="submit" value="Submit">
          </form:form>
          
    </body>