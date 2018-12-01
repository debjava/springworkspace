<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <div style="position: absolute;width: 800px;height: 100px;margin-top: 0px;">
	<h1>Welcome : ${pageContext.request.userPrincipal.name} </h1>
</div>

<div style="position: absolute;width: 200px;height: 100px;margin-left: 810px;">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		Logged in as : ${pageContext.request.userPrincipal.name} <a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
	</c:if>
</div>

<div style="position: absolute;width: 800px;height: 400px;margin-top: 120px;">
	<a href="studentsview">Click here to see the students details</a>
</div>

</body>
</html>