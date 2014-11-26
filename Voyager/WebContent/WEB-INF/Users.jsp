<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
	<td>Username</td>
	<td>Email</td>
	<td>Role</td>
	</tr>
	<c:forEach var="user" items="${userList }">
	<tr>
	<td>${user.username }</td>
	<td>${user.email }</td>
	<td>${user.role }</td>
	<td>
		<form action="<%= request.getContextPath() %>/voyager/delete" method="post">
		<input type="hidden" value="${user.username }" name="username" />
		<input type="submit" value="delete" />
		</form>
	</td>
	<td>
		<form action="<%= request.getContextPath() %>/voyager/updateRole" method="post">
		<input type="hidden" value="${user.username }" name="username"/>
		<select name="role">
			<option value="User">User</option>
			<option value="Admin">Admin</option>
		</select>
		<input type="submit" value="update" />
		</form>
	</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>