<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<jsp:include page="navadmin.jsp"></jsp:include>

	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><spring:message code="fidelite.title.list"/> </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
		      		
				        <th><spring:message code="fidelite.idFidelite"/> </th>
				        <th><spring:message code="fidelite.fd"/> </th>
				        <th><spring:message code="fidelite.reduction"/> </th>
				       
				       
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${fidelites}" var="fidelite">
					<tr>
					
						<td>${fidelite.idFidelite} </td>
						<td>${fidelite.fd}</td>
						<td>${fidelite.reduction}</td>
						<td><a href="<c:url value='/edit-fidelite-${fidelite.idFidelite}' />" class="btn btn-success custom-width"><spring:message code="button.update"/></a></td>
						<td><a href="<c:url value='/delete-fidelite-${fidelite.idFidelite}' />" class="btn btn-danger custom-width"><spring:message code="button.delete"/></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newfidelite' />"><spring:message code="fidelite.title.add"/></a>
	 	</div>
   	</div>
</body>
</html>