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
		  	<div class="panel-heading"><span class="lead"><spring:message code="voyage.title.list"/> </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
		      		
				        <th><spring:message code="voyage.idVoyage"/> </th>
				        <th><spring:message code="voyage.image"/> </th>
				        <th><spring:message code="voyage.pays"/> </th>
				        <th><spring:message code="voyage.villeDepart"/> </th>
				        <th><spring:message code="voyage.villeArrivee"/> </th>
				        <th><spring:message code="voyage.dateDepart"/> </th>
				        <th><spring:message code="voyage.dateArrivee"/> </th>
				        <th><spring:message code="voyage.prix"/> </th>
				        <th><spring:message code="voyage.nbDispo"/> </th>
				        <th><spring:message code="voyage.nbVendu"/> </th>
				       
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${voyages}" var="voyage">
					<tr>
					
						<td>${voyage.idVoyage} </td>
						<td>${voyage.image}</td>
						<td>${voyage.pays}</td>
						<td>${voyage.villeDepart}</td>
						<td>${voyage.villeArrivee}</td>
						<td>${voyage.dateDepart}</td>
						<td>${voyage.dateArrivee}</td>
						<td>${voyage.prix}</td>
						<td>${voyage.nbDispo}</td>
						<td>${voyage.nbVendu}</td>
						<td><a href="<c:url value='/edit-voyage-${voyage.idVoyage}' />" class="btn btn-success custom-width"><spring:message code="button.update"/></a></td>
						<td><a href="<c:url value='/delete-voyage-${voyage.idVoyage}' />" class="btn btn-danger custom-width"><spring:message code="button.delete"/></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newvoyage' />"><spring:message code="voyage.title.add"/></a>
	 	</div>
   	</div>
</body>
</html>