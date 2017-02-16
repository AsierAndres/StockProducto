<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
	<h1><s:message code="body.listStock"></s:message></h1>
	<p><s:message code="body.listStock1"></s:message></p>
</div>

	<table class="table">
		<thead>
			<tr>
				<th>Estanteria</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stocks}" var="stock">
				<tr>
					<td>${stock.estanteria}</td>
					<td>${stock.description}</td>
					<td><a class="btn btn-success" href="<s:url value="/stocks/${stock.id}" />"
						title="Detailed info"> see detail</a> || <a class="btn btn-warning"
						href="<c:url value="/stocks/update/${stock.id}" />">update</a> ||
						<a class="btn btn-danger" href="<c:url value="/stocks/delete/${stock.id}" />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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