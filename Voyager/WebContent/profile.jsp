<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; ${currentUser.username}</title>
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
			<h1>${profileAccount.username}</h1>

			<section class="hrContainer">
				<hr />
			</section>

			<img src="${pageContext.request.contextPath}/voyager/image/${profileAccount.avatar}" alt="avatar" />
			<br /> <br />
			<section class="content">
				<fmt:parseNumber var="localAccount" value="${profileAccount.userId }" />
				<fmt:parseNumber var="loggedAccount" value="${account.userId }" />
				<c:if test="${localAccount eq loggedAccount}">
					<a href="${pageContext.request.contextPath}/voyager/update" id="wrench"> <i class="fa fa-cog fa-3x" title="Account Settings"></i></a>
				</c:if>
			</section>
		</section>


		<h3 class="commentHeader">Comments ${profileAccount.username}'s Made</h3>
		<c:forEach var="comment" items="${profileAccount.comments }">
			<section class="commentBox">
				<p>${comment.location.name }</p>
				<p>
					<fmt:formatDate value="${comment.time }" type="BOTH" />
				</p>
				<p>${comment.comment }</p>
			</section>
		</c:forEach>
	</article>
</body>
</html>