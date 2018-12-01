<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
<html>
<title>Students View</title>

<script type="text/javascript">

	function submitForm(paramValue) {
		document.getElementById("actionId").value=paramValue;
		document.getElementById("manageFormId").submit();
	}
</script>
<body>

<div style="position: absolute;width: 800px;height: 100px;margin-top: 0px;">
	<h1>Student Details</h1>
</div>

<div style="position: absolute;width: 200px;height: 100px;margin-left: 810px;">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		Logged in as : ${pageContext.request.userPrincipal.name} <a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
	</c:if>
</div>


<div style="position: absolute;width: 800px;height: 400px;margin-top: 120px;">

<form action="manageAction" method="POST" name="manageForm" id="manageFormId">

<input id="actionId" type="hidden" name="actionName" value="">
<table>
	<tr>
		<td>Name : </td>
		<td><form:input path="student.name" readonly="true"/></td>
	</tr>
	<tr>
		<td>Roll No : </td>
		<td><form:input path="student.rollNo" readonly="true"/></td>
	</tr>
	<tr>
		<td>Total Marks : </td>
		<td><form:input path="student.marks" /></td>
	</tr>
</table>

<input type="button" name="deleteStudent" id="deleteStudentId" value="Remove Student" onclick="submitForm('delete');">

<input type="button" name="modifyMarks" id="modifyMarksId" value="Modify Marks" onclick="submitForm('modify');">

</form>
	
</div>

</body>
</html>