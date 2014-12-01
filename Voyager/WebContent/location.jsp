<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; ${location.name}</title>
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
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/home" class="navLink">HOME</a></section>
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/locations" class="navLink">LOCATIONS</a></section>
				<section class="menuBg"><a href="profile.html" class="navLink">PROFILE</a></section>
				<hr />
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/register" class="navLink">REGISTER</a></section>
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/login" class="navLink">LOGIN</a></section>
			</menu>
		</nav>

		<footer>
			<section id="footerContainer">
				Voyager &copy; 2014 <br /> All Rights Reserved
			</section>
		</footer>
	</section>

	<article class="mainContainer">
		<section class="topContent">
			<h1>${location.name}</h1>
			
			<img src="${pageContext.request.contextPath}/${location.picture}" alt="avatar"/>
		</section>

		<article class="contentContainer">
			<section class="postDetails">
				<h3>${location.location}</h3>
				${location.history}

				<!-- <section class="commentsContainer">
					<c:forEach var="comment" items="${comments}">
						<section class="commentBox">
							${comment.user} <br />
							<c:out value="${comment.comment}" />
						</section>
					</c:forEach>

				</section>-->
			</section>
		</article>
	</article>
</body>
</html>