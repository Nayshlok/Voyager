<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; Update</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"></head>
<body>
	<%@ include file="/WEB-INF/sidebar.jsp" %> 

	<article class="bodyContainer">
		<h1>Update User</h1>
		<form action="<%= request.getContextPath() %>/voyager/update" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${account.userId }"/>
			<label>Password:</label><input	name="password" type="password" /> 
			<label>Confirm Password:</label><input name="confirmPassword" type="password" />
			<label>Email Address:</label><input name="email" type="email" />
			<label>Confirm Email:</label><input name="confirmEmail" type="email" />
			<label>Profile Image:</label><input name="image" type="file" />
			<input type="submit" value="Update" id="submit" />
		</form>

	</article>
</body>
</html>