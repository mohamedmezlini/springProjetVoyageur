<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
		<div class="well lead"><spring:message code="recherche.title.add"/></div>
		<form method="POST" action="recherche"
			class="form-horizontal">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">recherche</label>
					<div class="col-md-7">
						<input  type="text"  id="value"  name="value"
							class="form-control input-sm" />
						
					</div>
				</div>
			</div>		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">Genre</label>
					<div class="col-md-7">
						<input type="radio" name="type" value="voyage" checked> <spring:message code="menu.voyages"/><br>
  						<input type="radio" name="type" value="client"> <spring:message code="menu.clients"/><br>
  
						
					</div>
				</div>
			</div>



	<div class="row">
		<div class="form-actions floatRight">
			
					<input type="submit" value="Rechercher"
						class="btn btn-primary btn-sm" /> 
				
		</div>
	</div>
	</form>
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
		
	 	
	 	
   	</div>
</body>
</html>