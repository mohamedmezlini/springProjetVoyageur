<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<jsp:include page="navadmin.jsp"></jsp:include>


	<div class="generic-container">
		<div class="well lead"><spring:message code="contact.title.add"/></div>
		<form:form method="POST" modelAttribute="contact"
			class="form-horizontal">
			<form:input type="hidden" path="idContact" id="idContact" />
	
		
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="contact.objet"/></label>
					<div class="col-md-7">
						<form:input type="text" path="objet" id="objet"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="objet" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="contact.sujet"/></label>
					<div class="col-md-7">
						<form:input type="text" id="sujet" path="sujet"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="sujet" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="contact.repondre"/></label>
					<div class="col-md-7">
						<form:input type="text" id="repondre" path="repondre"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="repondre" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

	<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="Client">Client</label>
				<div class="col-md-7">
					<form:select path="client" items="${clients}" multiple="false" itemValue="idClient" itemLabel="prenom"  class="form-control input-sm" />
					
					<div class="has-error">
						<form:errors path="client" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


			
	


	<div class="row">
		<div class="form-actions floatRight">
			<c:choose>
				<c:when test="${edit}">
					<input type="submit" value="Update" class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listcontact' />">Cancel</a>
				</c:when>
				<c:otherwise>
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listcontact' />">Cancel</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</form:form>
	</div>
</body>
</html>