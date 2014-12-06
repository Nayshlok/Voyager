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
	<%@ include file="/WEB-INF/sidebar.jsp"%>

	<article class="mainContainer">
		<section class="topContent">
			<h1>Submitted Locations</h1>

		</section>

		<article class="contentContainer">
			<div id="columns">
				<c:forEach var="loc" items="${location}">
					<div class="pin">
						<a href="${pageContext.request.contextPath}/voyager/loc/${loc.id}"><img
							src="${pageContext.request.contextPath}/${loc.picture}" /></a>
						<hr />
						<h3>${loc.location}</h3>
						<h2 class="title">${loc.name}</h2>
						<p>${loc.history}</p>
						<br />
					</div>
				</c:forEach>
			</div>
		</article>
	</article>
</body>
</html>