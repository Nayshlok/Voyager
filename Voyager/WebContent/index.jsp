<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; Home</title>
<link href="${pageContext.request.contextPath}/resources/home.css" rel="stylesheet"/>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            $("#submit").hover(
                function () {
                    $("#icon").css({
                        "color": "#2db0d6"
                    });
                },
                function () {
                    $("#icon").css({
                        "color": "white"
                    });
                }
            );
        });
    </script>

</head>

<body>
	<%@ include file="/WEB-INF/sidebar.jsp" %> 
    <article id="mainContainer">

        <section id="topContainer">
            <h1>VOYAGER</h1>

            <h2 id="tagLine">Tell Us Where <span id="it"><em>You've</em></span> Been, <br/><br/>
            Or...
            </h2>
            <section id="searchContainer">
                <section class="box">
                    <form class="container-1">
                        <span class="icon"><i class="fa fa-search fa-2x" id="icon"></i></span>
                        <input type="search" id="search" placeholder="Start Searching..." autocomplete="off" />
                        <input type="submit" id="submit" nam="submit" value="" />
                    </form>
                </section>

            </section>
        </section>

    </article>


</body>
</html>