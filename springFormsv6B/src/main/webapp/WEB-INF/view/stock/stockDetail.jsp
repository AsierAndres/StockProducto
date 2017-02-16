<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
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
	<h1><s:message code="body.stocksDetail"></s:message></h1>
	<p><s:message code="body.stocksDetail1"></s:message></p>
</div>

	<c:choose>
		<c:when test="${not empty stock}">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Estanteria</th>
						<th>Description</th>
						<th>Cantidad</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${stock.id}</td>
						<td>${stock.estanteria}</td>
						<td>${stock.description}</td>
						<td>${stock.cantidad}</td>
					</tr>
				</tbody>
			</table>

			<h3>Productos</h3>
			<h4>Insert new producto</h4>
			<c:url var="post_producto" value="/productos/new" />
			<sf:form method="post" modelAttribute="producto"
				action="${post_producto}">
				<sf:hidden path="stock.id" />
				<div class="form-group">
					<label for="name">Name</label>
					<sf:input path="name" class="form-control" placeholder="Name" />
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<sf:textarea path="description" class="form-control" type="description"
						placeholder="Description" />
				</div>
				<sf:button>Create</sf:button>
			</sf:form>
			<p>These are the productos for this stock.</p>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${stock.getProductos()}" var="producto">
						<tr>
							<td>${producto.id}</td>
							<td>${producto.name}</td>
							<td><a class="btn btn-success" href="<s:url value="/productos/${producto.id}" />"
								title="Detailed info"> See detail</a> || <a class="btn btn-warning"
								href="<c:url value="/productos/update/${producto.id}" />">Update</a>
								|| <a class="btn btn-danger" href="<c:url value="/productos/delete/${producto.id}" />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:when>
		<c:otherwise>
			<div>A stock with the id specified has not been found. Please,
				try again</div>
		</c:otherwise>
	</c:choose>
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