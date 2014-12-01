<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; Locations</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>

<body>
	<section id="sideContainer">
		<i class="fa fa-compass fa-5x compass"></i>
		<nav>
			<menu>
				<section class="menuBg">
					<a href="${pageContext.request.contextPath}/voyager/home"
						class="navLink">HOME</a>
				</section>
				<section class="menuBg">
					<a href="${pageContext.request.contextPath}/voyager/locations"
						class="navLink">LOCATIONS</a>
				</section>
				<section class="menuBg">
					<a href="profile.html" class="navLink">PROFILE</a>
				</section>
				<hr />
				<section class="menuBg">
					<a href="${pageContext.request.contextPath}/voyager/register"
						class="navLink">REGISTER</a>
				</section>
				<section class="menuBg">
					<a href="${pageContext.request.contextPath}/voyager/login"
						class="navLink">LOGIN</a>
				</section>
			</menu>
		</nav>

		<footer>
			<section id="footerContainer">
				Voyager &copy; 2014 <br />All Rights Reserved
			</section>
		</footer>
	</section>

	<article class="mainContainer">
		<section class="topContent">
			<h1>Submitted Locations</h1>

		</section>

		<article class="contentContainer">
			<div id="wrapper">
				<div id="columns">
					<%-- <a href="${pageContext.request.contextPath}/voyager/loc/1">
						<div class="pin">
							<img src="${pageContext.request.contextPath}/resources/ph.png" />
							<hr />

							<h3>${location.title}</h3>
							<h3 class="author">${location.author}</h3>
							<p>${location.message} Lorem ipsum dolor sit amet,
								consectetur adipiscing elit. Sed feugiat consectetur
								pellentesque. Nam ac elit risus, ac blandit dui. Duis rutrum
								porta tortor ut convallis. Duis rutrum porta tortor ut
								convallis.</p>
						</div>
					</a>--%>

					<c:forEach var="loc" items="${allLocations}">
						<div class="pin">
							<img src="${pageContext.request.contextPath}/${loc.picture}" />
							<hr />
							<h3>${loc.location}</h3>
							<h2 class="author">${loc.name}</h2>
							<p>${loc.history}</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</article>
	</article>
</body>
</html>