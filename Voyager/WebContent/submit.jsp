<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Voyager &#124; New Location</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
    <%@ include file="/WEB-INF/sidebar.jsp" %> 

    <article class="mainContainer">
        <section class="topContent">
            <h1>Submit New Location</h1>
        </section>

        <article class="contentContainer">

            <section class="formContainer">
                
                <form method="post" enctype="multipart/form-data">
                    <label>Name:</label>
                    <input name="placeName" type="text" placeholder="Ex: Amarillo, Texas; Boonies, OK" class="textEntry" required /><br/>
                    <label>Description:</label>
                    <input name="history" type="textarea" class="textarea" required/><br/>
                    <label>Display Image:</label>
                    <input name="image" type="file" class="custom-file-input"/><br/>
                    <input type="submit" value="Submit" id="submit" />
                </form>
            </section>
        </article>
    </article>
</body>
</html>