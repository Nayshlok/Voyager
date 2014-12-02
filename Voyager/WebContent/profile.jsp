<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; ${currentUser.username}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
    <%@ include file="/WEB-INF/sidebar.jsp" %> 

    <article class="mainContainer">
        <section class="topContent">
            <h1>${account.username}</h1>

            <section class="hrContainer">
                <hr/>
            </section>


            <img src="${pageContext.request.contextPath}/ph.png" alt="avatar"/>
            <br/>
            <br/>
            <section class="content"></section>
        </section>


        <h2>Recent Comments</h2>
        <hr class="div" />
        
        <form action="${pageContext.request.contextPath}/UserProfileServlet"
			method="post">
			<input type="submit" name="logout" value="Logout" /> <input
				type="submit" name="update" value="Update" />
		</form>
        </article>
        
    </article>
</body>
</html>