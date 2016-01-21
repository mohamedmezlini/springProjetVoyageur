
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />



		<nav class="  navbar navbar-default navbar-fixed-top nav-menu-milieu" >
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <span class=" fa fa-2x fa-plane">leVoyageur </span></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a  href="/"   role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.home"/>  <span class="sr-only">(current)</span></a></li>
						<li class=""><a href="listvoyage"  role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.voyages"/></a></li>
						<li class=""><a href="listcontact"  		role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.contacts"/></a></li>
						<li class=""><a href="listnewsletter"  		role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.newsletters"/></a></li>
						<li class=""><a href="listclient"  		role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.clients"/></a></li>
						<li class=""><a href="listfidelite"  		role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.statistiques"/> </a></li>
					<li class=""><a href="recherche"  		role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="menu.recherche"/> </a></li>
						
					</ul>
					


					<ul class="nav navbar-nav pull-right">



						<li class="dropdown" id="menuLogin">
						<a href="listclient?mylocale=en">English </a></li> <li class="dropdown" id="menuLogin"> <a href="listclient?mylocale=fr">Français </a>
</li> <li class="dropdown" id="menuLogin">
	 <button class="dropdown-toggle    btn btn-warning fa fa-user" href="#" data-toggle="dropdown" id="menuLogin">Bienvenue 
								


								
							</button>
							<div  class="dropdown-menu col-lg-8" style="padding:17px;">

								
								
								

								<div class="lienpc">
									<a class=" btn btn-warning" href="/Deconnexion"> Deconnexion</a>
								</div>

								
							</div>



					</li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>

