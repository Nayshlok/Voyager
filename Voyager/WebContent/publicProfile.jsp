<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% String strname =(String)request.getAttribute("Username");%> 
           <%pageContext.getOut().println(strname);%></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
</head>
<body>
<header>
		
	</header>
	<article class="bodyContainer">
		<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
		</br>
		     Username:<%pageContext.getOut().println(strname);%>
	</article>
	<nav>
			<ul>
			
				<li>Home</li> &bull;
				<li>Search</li>&bull;
			</ul>
		</nav>
	
	<table border="1">
	<tr>
	<td>
	<textarea rows="4" cols="50">
	<% String c =(String)request.getAttribute("comment");%> 
    <%pageContext.getOut().println(c);%>
    </textarea>
	</td>
	<td>
	<textarea rows="4" cols="50">
	recent comment
	</textarea>
	</td>
	<td>
	<textarea rows="4" cols="50">
	recent comment
	</textarea>
	</td>
	</tr>
	</table>

	
	<table border="1" cellpadding="5">

	<tr>
	
	<td align="center" valign="center">
		<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
	<br />
	Caption text centered under the image.
	</td>
	
	<td align="center" valign="center">
		<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
	<br />
	Caption text centered under the image.
	</td>
		<td align="center" valign="center">
		<img src="${pageContext.request.contextPath}/TestPic/avatar.png" />
	<br />
	Caption text centered under the image.
	</td>
	
	</tr>
	
	</table>
	
</body>
</html>