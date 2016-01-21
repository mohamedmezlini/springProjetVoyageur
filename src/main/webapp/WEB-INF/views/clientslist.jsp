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
		  	<div class="panel-heading"><span class="lead"><spring:message code="client.title.list"/> </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
		   
				        <th><spring:message code="client.idClient"/> </th>
				        <th><spring:message code="client.nom"/> </th>
				        <th><spring:message code="client.prenom"/> </th>
				        <th><spring:message code="client.adresse"/> </th>
				        <th><spring:message code="client.mail"/> </th>
				        <th><spring:message code="client.tel"/> </th>
				        <th><spring:message code="client.cin"/> </th>
				        <th><spring:message code="client.login"/> </th>
				        <th><spring:message code="client.mdp"/> </th>
				        <th><spring:message code="client.role"/> </th>
				        <th><spring:message code="client.age"/> </th>
				       
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${clients}" var="client">
					<tr>
					
						<th>${client.idClient} </th>
				        <th>${client.nom} </th>
				        <th>${client.prenom} </th>
				        <th>${client.adresse} </th>
				        <th>${client.mail} </th>
				        <th>${client.tel} </th>
				        <th>${client.cin} </th>
				        <th>${client.login} </th>
				        <th>${client.mdp} </th>
				        <th>${client.role} </th>
				        <th>${client.age} </th>
						<td><a href="<c:url value='/edit-client-${client.idClient}' />" class="btn btn-success custom-width"><spring:message code="button.update"/></a></td>
						<td><a href="<c:url value='/delete-client-${client.idClient}' />" class="btn btn-danger custom-width"><spring:message code="button.delete"/></a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newclient' />"><spring:message code="client.title.add"/></a>
	 	</div>
   	</div>
</body>
</html>