<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
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

		<section id="profileInfo">
			<h1>Welcome!</h1>
			<img src="${pageContext.request.contextPath}/TestPic/avatar.png"
				id="profilePic" /> <br />
			<section id="pI-text">
				<h2>
					<%
					String strname = (String) request.getAttribute("Username");
					pageContext.getOut().println(strname);
				%>
				</h2>
			</section>
		</section>

		<section id="commentContainer">
		<h2>Recent Comments</h2>
			<div class="comment">
				<%
					String c = (String) request.getAttribute("comment");
					pageContext.getOut().println(c);
				%>
			</div>

			<div class="comment">
				<%
					pageContext.getOut().println(c);
				%>
			</div>

			<div class="comment">
				<%
					pageContext.getOut().println(c);
				%>
			</div>
		</section>
		
		<hr/>
		<section id="locationContainer">
		<h2>Submitted Locations</h2>
			<section class="locationItem">
				<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
				<br /> Caption text centered under the image.
			</section>
			<section class="locationItem">
				<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
				<br /> Caption text centered under the image.
			</section>
			<section class="locationItem">
				<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
				<br /> Caption text centered under the image.
			</section>
		</section>

		<form action="${pageContext.request.contextPath}/UserProfileServlet"
			method="post">
			<input type="submit" name="logout" value="Logout" /> <input
				type="submit" name="update" value="Update" />
		</form>
	</article>
</html>