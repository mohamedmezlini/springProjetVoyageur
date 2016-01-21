<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<jsp:include page="navadmin.jsp"></jsp:include>



	<div class="generic-container">
		<div class="well lead"><spring:message code="client.title.add"/></div>
		<form:form method="POST" modelAttribute="client"
			class="form-horizontal">
			<form:input type="hidden" path="idClient" id="idClient" />
	



			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.prenom"/></label>
					<div class="col-md-7">
						<form:input type="text" id="prenom" path="prenom"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="prenom" class="help-inline" />
						</div>
					</div>
				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.nom"/></label>
					<div class="col-md-7">
						<form:input type="text" id="nom" path="nom"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="nom" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.login"/></label>
					<div class="col-md-7">
						<form:input type="text" id="login" path="login"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="login" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.mail"/></label>
					<div class="col-md-7">
						<form:input type="text" id="mail" path="mail"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="mail" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.mdp"/></label>
					<div class="col-md-7">
						<form:input type="password" id="mdp" path="mdp"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="mdp" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.age"/></label>
					<div class="col-md-7">
						<form:input type="number" path="age" id="age" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="age" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.tel"/></label>
					<div class="col-md-7">
						<form:input type="number" path="tel" id="tel" class="form-control" />
						<div class="has-error">
						<form:errors path="tel" class="help-inline" />
					</div>
				</div>
			</div>
			</div>
					<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.adresse"/></label>
					<div class="col-md-7">
						<form:input type="text" path="adresse" id="adresse"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="adresse" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.cin"/></label>
					<div class="col-md-7">
						<form:input type="text" path="cin" id="cin"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="cin" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="client.role"/></label>
					<div class="col-md-7">
						<form:input type="integer" path="role" id="role"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="role" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
	


	<div class="row">
		<div class="form-actions floatRight">
			<c:choose>
				<c:when test="${edit}">
					<input type="submit" value="Update" class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listclient' />">Cancel</a>
				</c:when>
				<c:otherwise>
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listclient' />">Cancel</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</form:form>
	</div>
</body>
</html>