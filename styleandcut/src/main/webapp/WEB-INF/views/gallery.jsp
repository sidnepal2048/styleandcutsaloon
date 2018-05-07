<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	var formData= new FormData();
	formData.append("myImage", document.getElementById("image").files[0]);
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "Admin/uploadImage");
	shr.send(formData);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/Admin/uploadImage" method="post" enctype="multipart/form-data">
		<input id="image" type="file" name="myImage">
		<input type="submit" id="image"  value="Upload">
	</form:form>
</body>
</html>