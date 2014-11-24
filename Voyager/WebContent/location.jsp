<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; ${location.name}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	
</head>
<body>
  <section id="sideContainer">
        <i class="fa fa-compass fa-5x compass"></i>
        <nav>
            <menu>
                <section class="menuBg"><a href="${pageContext.request.contextPath}/home" class="navLink">HOME</a>
                </section>
                <section class="menuBg"><a href="${pageContext.request.contextPath}/locations" class="navLink">LOCATIONS</a>
                </section>
                <section class="menuBg"><a href="profile.html" class="navLink">PROFILE</a>
                </section>
                <hr/>
                <section class="menuBg"><a href="${pageContext.request.contextPath}/register" class="navLink">REGISTER</a>
                </section>
                <section class="menuBg"><a href="${pageContext.request.contextPath}/login" class="navLink">LOGIN</a>
                </section>
            </menu>
        </nav>

          <footer>
            <section id="footerContainer">
                Voyager &copy; 2014 <br/>
                All Rights Reserved
            </section>
        </footer>
    </section>

    <article class="mainContainer">
        <section class="topContent">
            <h1 >${location.name}</h1>
        </section>

        <article class="contentContainer">
	
        </article>
    </article>
</body>
</html>