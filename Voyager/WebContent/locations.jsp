<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; Submissions</title>
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
	<article id="wrapper">
		<h1>Recent Submissions</h1>
		<hr />

		<!-- <section id="wrapper">-->
		<section id="columns">
			<section class="locationPost">

				<img src="${pageContext.request.contextPath}/resources/ph.png" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} <br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>

			<section class="locationPost">
				<img src="${pageContext.request.contextPath}/resources/ph2.jpg" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} <br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>

			<section class="locationPost">
				<img src="${pageContext.request.contextPath}/resources/ph3.jpg" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} <br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>

			<section class="locationPost">
				<img src="${pageContext.request.contextPath}/resources/ph2.jpg" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} <br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>

			<section class="locationPost">
				<img src="${pageContext.request.contextPath}/resources/ph.png" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} <br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>

			<section class="locationPost">
				<img src="${pageContext.request.contextPath}/resources/ph3.jpg" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} <br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>

			<section class="locationPost">
				<img src="${pageContext.request.contextPath}/resources/ph.png" />
				<section class="locationData">
					<div class="title">
						<h2 class="postTitle">${location.title}</h2>
						<div class="author">${location.author}</div>
					</div>
					<hr />
					<div class="message">${location.message}</div>
					<hr />
					<div class="comments">
						<c:forEach var="comment" items="${comments}">
							<section class="commentBox">
							${comment.user} 
							<br/>
								<c:out value="${comment.comment}" />
							</section>
						</c:forEach>
					</div>
				</section>
			</section>
		</section>
		<!-- </section>-->
	</article>
</body>
</html>