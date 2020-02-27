<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

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

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap.css" rel="stylesheet">


<!-- Bootstrap Glyphicons css -->
<link href="${css}/bootstrap-glyphicons.css" rel="stylesheet">

<!-- Theme -->
<link href="${css}/theme2.css" rel="stylesheet">

<!-- Bootstrap DataTable CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles  -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">

			<!-- Page Content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if test="${userClickBuyProducts == true }">
				<%@include file="buyProducts.jsp"%>
			</c:if>

			<c:if test="${userClickViewProduct == true }">
				<%@include file="viewProduct.jsp"%>
			</c:if>
			
			<c:if test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>

		</div>
		<!-- Content div close -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

	</div>

	<!-- JQuery -->

	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap core JavaScript -->

	<script src="${js}/bootstrap.min.js"></script>

	<!-- DataTables Plugin -->

	<script src="${js}/jquery.dataTables.js"></script>

	<script src="${js}/dataTables.bootstrap4.js"></script>

	<!-- Own javascript -->
	<script src="${js}/myapp.js"></script>

</body>

</html>
