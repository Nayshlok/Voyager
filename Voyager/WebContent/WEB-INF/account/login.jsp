
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	
</head>
<body>
  <section id="sideContainer">
        <i class="fa fa-compass fa-5x compass"></i>
        <nav>
            <menu>
                <section class="menuBg"><a href="index.html" class="navLink">HOME</a>
                </section>
                <section class="menuBg"><a href="locations.html" class="navLink">LOCATIONS</a>
                </section>
                <section class="menuBg"><a href="#" class="navLink">SEARCH</a>
                </section>
                <section class="menuBg"><a href="profile.html" class="navLink">PROFILE</a>
                </section>
                <hr/>
                <section class="menuBg"><a href="register.html" class="navLink">REGISTER</a>
                </section>
                <section class="menuBg"><a href="login.html" class="navLink">LOGIN</a>
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
            <h1>Login Existing User</h1>
        </section>

        <article class="contentContainer">

            <section class="formContainer">
                <p><%=(request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage")) %></p>-->
                <form method="post" enctype="multipart/form-data">
                    <label>Username:</label>
                    <input name="username" type="text" value="<%= current.getUsername() %>" class="textEntry" /><br/>
                    <label>Password:</label>
                    <input name="password" type="password" class="textEntry"/><br/>
                    <input type="submit" value="Login" id="submit" />
                </form>
            </section>
        </article>
    </article>
</body>
</html>