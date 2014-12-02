<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
			<hr />
			
			<c:choose>
				<c:when test="${empty account}">
					<section class="menuBg">
						<a href="${pageContext.request.contextPath}/voyager/register"
						class="navLink">REGISTER</a>
					</section>
					
					<section class="menuBg">
						<a href="${pageContext.request.contextPath}/voyager/login"
							class="navLink">LOGIN</a>
					</section>
				</c:when>
				
				<c:otherwise>
					<section class="menuBg">
						<a href="profile.html" class="navLink">PROFILE</a>
					</section>
			
					<section class="menuBg">
						<a href="${pageContext.request.contextPath}/voyager/login"
							class="navLink">LOGOUT</a>
					</section>
				</c:otherwise>
			</c:choose>
			
			
			
		</menu>
	</nav>

	<footer>
		<section id="footerContainer">
			Voyager &copy; 2014 <br /> All Rights Reserved
		</section>
	</footer>
</section>