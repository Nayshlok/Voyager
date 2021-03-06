
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
  	<%@ include file="/WEB-INF/sidebar.jsp" %>

    <article class="mainContainer">
        <section class="topContent">
            <h1>Login Existing User</h1>
        </section>

        <article class="contentContainer">

            <section class="formContainer">
                <p><%=(request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage")) %></p>
                <form method="post" enctype="multipart/form-data">
                    <label>Username:</label>
                    <input name="username" type="text" class="textEntry"  autocomplete="off"/><br/>
                    <label>Password:</label>
                    <input name="password" type="password" class="textEntry"/><br/>
                    <input type="submit" value="Login" id="submit" />
                </form>
            </section>
        </article>
    </article>
</body>
</html>