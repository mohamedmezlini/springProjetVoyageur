<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyage Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<jsp:include page="navadmin.jsp"></jsp:include>


	<div class="generic-container">
		<div class="well lead"><spring:message code="voyage.title.add"/></div>
		<form:form method="POST" modelAttribute="voyage"
			class="form-horizontal">
			<form:input type="hidden" path="idVoyage" id="idVoyage" />
			<form:errors path="idVoyage" class="help-inline" />
			<form:input type="hidden" path="nbVendu" id="nbVendu" />
			<form:errors path="nbVendu" class="help-inline" />
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.pays"/></label>
					<div class="col-md-7">
						<form:input type="text" path="pays" id="pays"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="pays" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.villeDepart"/></label>
					<div class="col-md-7">
						<form:input type="text" id="villeDepart" path="villeDepart"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="villeDepart" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.villeArrivee"/></label>
					<div class="col-md-7">
						<form:input type="text" id="villeArrivee" path="villeArrivee"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="villeArrivee" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.dateDepart"/></label>
					<div class="col-md-7">
						<form:input type="date" id="dateDepart" path="dateDepart"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="dateDepart" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.dateArrivee"/></label>
					<div class="col-md-7">
						<form:input type="date" id="dateArrivee" path="dateArrivee"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="dateArrivee" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.image"/></label>
					<div class="col-md-7">
						<form:input type="text" id="image" path="image"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="image" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.nbDispo"/></label>
					<div class="col-md-7">
						<form:input type="number" path="nbDispo" id="nbDispo"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="nbDispo" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="voyage.prix"/></label>
					<div class="col-md-7">
						<form:input type="number" path="prix" id="prix" class="form-control" />
						<div class="has-error">
						<form:errors path="prix" class="help-inline" />
					</div>
				</div>
			</div>
			</div>
	


	<div class="row">
		<div class="form-actions floatRight">
			<c:choose>
				<c:when test="${edit}">
					<input type="submit" value="Update" class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listvoyage' />">Cancel</a>
				</c:when>
				<c:otherwise>
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listvoyage' />">Cancel</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</form:form>
	</div>
</body>
</html>