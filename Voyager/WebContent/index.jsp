<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

</head>
<body>
<header>
	<nav>
		<ul>
		<li>Home</li> &bull;
		<li>Profile</li> &bull;
		<li>Submit</li> &bull;
		<li>Search</li>
		</ul>
	</nav>
</header>
<article class="bodyContainer">
	<form method="post">
		<input type="submit" value="Login"/>
	</form>
	
	<form method="get" action="<%= request.getContextPath()%>/register">
		<input type="submit" value="Register"/>
	</form>

</article>
</body>
</html>