<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; Submit New</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
 <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

</head>

<body>
    <section id="sideContainer">
        <i class="fa fa-compass fa-5x compass"></i>
        <nav>
           <menu>
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/home" class="navLink">HOME</a></section>
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/locations" class="navLink">LOCATIONS</a></section>
				<section class="menuBg"><a href="profile.html" class="navLink">PROFILE</a></section>
				<hr />
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/register" class="navLink">REGISTER</a></section>
				<section class="menuBg"><a href="${pageContext.request.contextPath}/voyager/login" class="navLink">LOGIN</a></section>
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
            <h1>Submit New Location</h1>
        </section>

        <article class="contentContainer">

            <section class="formContainer">
                
                <form method="post" enctype="multipart/form-data">
                    <label>Name:</label>
                    <input name="placeName" type="text" placeholder="Ex: Texas; Boonies, OK" class="textEntry" required /><br/>
                    <label>Description:</label>
                    <input name="desc" type="textarea" class="textarea" required/><br/>
                    
                     <label>Attractions:</label>
                    <input name="desc" type="textarea" class="textarea" required/><br/>
                   
                    <label>Display Image:</label>
                    <input name="image" type="file" class="custom-file-input"/><br/>
                    <input type="submit" value="Submit" id="submit" />
                </form>
            </section>
        </article>
    </article>
</body>
</html>