<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Stocks</title>
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
				>
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
	<h1><s:message code="body.newStock"></s:message></h1>
	<p><s:message code="body.stocksDetail1"></s:message></p>
</div>

	<c:url var="post_stock" value="/stocks/new" />
	<sf:form method="post" modelAttribute="stock" action="${post_stock}">
		<div class="form-group">
			<label for="estanteria">Estanteria</label>
			<sf:input path="estanteria" class="form-control" placeholder="Estanteria" />
				<sf:errors path="estanteria" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="cantidad">Cantidad</label>
			<sf:input path="cantidad" class="form-control" placeholder="Cantidad" />
				<sf:errors path="cantidad" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="description">Description</label>
			<sf:textarea path="description" class="form-control" placeholder="Description" />
				<sf:errors path="description" cssClass="error" />
		</div>
		<sf:button>Create</sf:button>
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