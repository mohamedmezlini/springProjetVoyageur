<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/sigin.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="container-fluid">
		<form class="form-signin" method="post" action="login">

			<h2 class="form-signin-heading">Connectez-Vous</h2>
			<label for="inputEmail" class="sr-only">Log in </label> <input
				type="text" id="login" class="form-control" placeholder="log-in"
				required="required" autofocus="" name="login"				value="" size="20"
				maxlength="60" /> <label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" name="mdp" value="" size="20"
				maxlength="20" />
			<span>${error}</span>

			<button class="btn btn-lg btn-warning btn-block" type="submit">Sign
				in</button>







		</form>
	</div>
	</div>



</body>


</html>