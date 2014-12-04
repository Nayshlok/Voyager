<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; All Users</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/sidebar.jsp"%>

	<article class="mainContainer">

		<section class="topContent">
			<h1>All Users</h1>
		</section>

		<article class="contentContainer">
			<table>
				<tr>
					<td class="t-Header">Username</td>
					<td class="t-Header">Email</td>
					<td class="t-Header">Role</td>
				</tr>
				<c:forEach var="user" items="${userList }">
					<tr>
						<td><a href="<%= request.getContextPath()%>/voyager/user/${user.username}">${user.username }</a></td>
						<td>${user.email }</td>
						<td>${user.role }</td>
						<td>
							<form action="<%=request.getContextPath()%>/voyager/delete"
								method="post">
								<input type="submit" value="delete" />
								<input type="hidden" value="${user.username }" name="username" />
							</form>
						</td>
						<td>
							<form action="<%=request.getContextPath()%>/voyager/updateRole"
								method="post">
								<select name="role">
									<option value="User">User</option>
									<option value="Admin">Admin</option>
								</select> <input type="submit" value="update" />
								<input type="hidden" value="${user.username }" name="username" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>
	</article>

</body>
</html>