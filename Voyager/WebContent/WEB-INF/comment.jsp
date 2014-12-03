<section class="formContainer">
	<p><%=(request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage")) %></p>
	<form method="post" action="${pageContext.request.contextPath}/voyager/comment">
		<input name="locationId" type="hidden" value="${location.id }" /> <label>Enter
			Your Comments:</label><br />
		<textarea name="comment" rows="4" cols="50"></textarea>
		<br /> <input type="submit" value="submit" id="submit" />
	</form>
</section>