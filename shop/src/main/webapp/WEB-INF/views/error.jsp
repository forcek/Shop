<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>RK Traders - ${title}</title>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Glyphicons css -->
<link href="${css}/bootstrap-glyphicons.css" rel="stylesheet">

<!-- Theme -->
<link href="${css}/theme2.css" rel="stylesheet">

<!-- Custom styles  -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>

				</div>
			</div> 
		</nav>

		<!-- Content Error -->

		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12 col-sm-12">

						<div class="jumbotron">

							<h1>${errorTitle}</h1>
							<hr />

							<blockquote style="word-wrap: break-word">
								${errorDescription}
							</blockquote>

						</div>

					</div>

				</div>

			</div>

		</div>

		<!-- Content div close -->

		<!-- Footer -->

		<%@include file="./shared/footer.jsp"%>

	</div>


</body>

</html>
