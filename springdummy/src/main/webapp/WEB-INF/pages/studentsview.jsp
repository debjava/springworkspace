<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function submitForm(paramValue) {
	document.getElementById("studentId").value=paramValue;
	document.getElementById("someForm").submit();
}

</script>


<meta charset="ISO-8859-1">
<title>Students View</title>
</head>
<body>

<div style="border: 1px solid;position: absolute;width: 800px;height: 100px;margin-top: 0px;">
	<h1>Student Details</h1>
</div>

<div style="border: 1px solid;position: absolute;width: 200px;height: 100px;margin-left: 810px;">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		Logged in as : ${pageContext.request.userPrincipal.name} <a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
	</c:if>
</div>

<div style="border: 1px solid;position: absolute;width: 800px;height: 400px;margin-top: 120px;">

<form action="admin" method="POST" name="someForm" id="someForm"> 
	<input id="studentId" type="hidden" name="studentName" value="">
	<c:forEach items="${student}" var="elements">
	<a href="javascript: submitForm('${elements.name}')" >${elements.name}</a><br>
    <!-- <a href="#" onclick="document.someForm.submit();">${elements.name}</a><br>  -->
</c:forEach>
</form> 

<%-- 
<c:forEach items="${student}" var="elements">
	<c:set var="aaa" value="${elements.name}" scope="request" />
    <a href="admin?aaa=asdf">${elements.name}</a><br>
</c:forEach>
--%>

</div>

</body>
</html>