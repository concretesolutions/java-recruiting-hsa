<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" >
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script type="text/javascript" src='<c:url value="/js/angular.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/angular-route.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/app/components/seleccion/seleccionController.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/app/components/seleccion/seleccionService.js"/>'></script>
	

</head>
<body ng-app="app" ng-controller="controlador">

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Reto JAVA Concrete</h1>
		</div>

		<p>
			Hecho por Jose Moros.

			El proyecto esta hecho con SpringBoot con Gradle.

			Para consultar las API puedes ir a la siguiente direccion:
			Swagger:

			<a href="http://127.0.0.1:8094/swagger-ui.html#/">http://127.0.0.1:8094/swagger-ui.html#/</a>

		<p>

	</div>
	
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>