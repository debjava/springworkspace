<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Status</title>
</head>
<body>
<div style="position: absolute;width: 200px;height: 100px;margin-left: 810px;">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		Logged in as : ${pageContext.request.userPrincipal.name} <a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
	</c:if>
</div>
	${info}
	<a href="studentsview">Click here to see the students details</a>
</body>
</html>