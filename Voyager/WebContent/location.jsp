<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	
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
	<%@ include file="/WEB-INF/sidebar.jsp" %> 

	<article class="mainContainer">
		<section class="topContent">
			<h1>${location.name}</h1>
			<hr/>
			<br/>
			<img src="${pageContext.request.contextPath}/${location.picture}" alt="Location" class="locPic"/>
			
		</section>

		<article class="contentContainer">
			<section class="postDetails">
				<h3>${location.location}</h3>
				<section class="history">${location.history}</section>
			</section>
			
			
			<h3 class="commentHeader">Recent Comments</h3>
			<section class="commentsContainer">
					<c:forEach var="comment" items="${location.comments}">
						<section class="commentBox">
						   	<p><a href="<%= request.getContextPath()%>/voyager/user/${comment.user.username}">${comment.user.username }</a></p>
	        				<hr/>
	        				<p><fmt:formatDate value="${comment.time }" type="BOTH"/></p>
	        				<p>${comment.comment }</p>
						</section>
					</c:forEach>
			<c:if test="${not empty account}">
				<%@ include file="/WEB-INF/comment.jsp" %>
			</c:if> 
		</article>
	</article>
</body>
</html>