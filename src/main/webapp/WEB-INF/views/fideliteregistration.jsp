<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fidelite Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<jsp:include page="navadmin.jsp"></jsp:include>


	<div class="generic-container">
		<div class="well lead"><spring:message code="fidelite.title.add"/></div>
		<form:form method="POST" modelAttribute="fidelite"
			class="form-horizontal">
			<form:input type="hidden" path="idFidelite" id="idFidelite" />
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="fidelite.fd"/></label>
					<div class="col-md-7">
						<form:input type="text" path="fd" id="fd"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="fd" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="fidelite.reduction"/></label>
					<div class="col-md-7">
						<form:input type="text" path="reduction" id="reduction"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="reduction" class="help-inline" />
						</div>
					</div>
				</div>
			</div>


	<div class="row">
		<div class="form-actions floatRight">
			<c:choose>
				<c:when test="${edit}">
					<input type="submit" value="Update" class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listfidelite' />">Cancel</a>
				</c:when>
				<c:otherwise>
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/listfidelite' />">Cancel</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</form:form>
	</div>
</body>
</html>

