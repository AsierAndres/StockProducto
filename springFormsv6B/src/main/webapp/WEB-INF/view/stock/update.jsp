<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Update.jsp</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><s:message code="navbar.app"></s:message></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/stocks/" />" title="View users"><s:message
								code="navbar.stocks"></s:message></a></li>
					<li><a href="<s:url value="/stocks/new" />" title="New user"><s:message
								code="navbar.newStock"></s:message></a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="true"><s:message
								code="navbar.language"></s:message> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="?locale=en"><img src="blank.gif"
									class="flag flag-gb"
									alt="<s:message code="english"></s:message>" /> <s:message
										code="english"></s:message></a></li>
							<li><a href="?locale=es"><img src="blank.gif"
									class="flag flag-es"
									alt="<s:message code="spanish"></s:message>" /> <s:message
										code="spanish"></s:message></a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Update stock</h1>
		</div>


		<s:url var="action" value="/stocks/saveupdate" />
		<sf:form method="post" action="${action}" modelAttribute="stock">
			<sf:hidden path="id" />
			<div class="form-group">
				<label for="estanteria">Estanteria</label>
				<sf:input path="estanteria" placeholder="Estanteria" />
			</div>
			<div class="form-group">
				<label for="cantidad">Cantidad</label>
				<sf:input path="cantidad" placeholder="Cantidad" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" placeholder="Description" />
			</div>
			<sf:button>Update</sf:button>
		</sf:form>
		<footer>
			<div class="navbar container">
				<p class="text-muted">&copy; 2017 Asier Andrés</p>
			</div>
		</footer>
	</div>
		<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
		<script
			src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>
