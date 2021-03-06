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

	<a href="#">Stocks app</a>

	<ul>
		<li><a href="<s:url value="/stocks/" />" title="View stocks">View
				stocks</a></li>
		<li><a href="<s:url value="/stocks/new" />" title="New stock">New
				stock</a></li>
	</ul>

	<h1>Error</h1>

	<div class="alert alert-success" role="alert">The following error
		${error} arised when creating a new stock</div>

	<p class="text-muted">&copy; 2015 Eugenia Pérez</p>

</body>
</html>