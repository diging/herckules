<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML>

<html ng-app>
<head>
<title><tiles:insertAttribute name="title" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="viewport" content="width=1040" />

 
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/skel-noscript.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/style-desktop.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/multi-tab.css" />

	

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/skel-noscript.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/txt-layout/css/style-desktop.css" />

<script src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/html5shiv.js"></script>
<script	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/jquery-1.10.2.min.js"></script>
<script	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/d3.v2.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/jquery.dataTables.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/jquery.dropotron.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/config.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/skel.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/skel-panels.min.js"></script>
	
<script
	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/jquery-ui.js"></script>
	

<script
	src="${pageContext.servletContext.contextPath}/resources/txt-layout/js/jquery-ui.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/angular.min.js">
<script src="${pageContext.servletContext.contextPath}/resources/js/projectController.js">
</head>
<body class="homepage">
	<tiles:importAttribute name="currentPage" scope="request" />
	<!-- Header Wrapper -->
	<div id="header-wrapper">

		<!-- Header -->
		<div id="header" class="container">

			<!-- Logo -->
			<h1>
				<a href="#">Herckules</a>
			</h1>
			<tiles:insertAttribute name="navigation" />
		</div>
	</div>

	<!-- Main Wrapper -->
	<div id="main-wrapper">
		<!-- Main -->
		<div id="main" class="container">
			
			<div class="row flush">
				
					<div class="row">


						<div class="4u">
							<div class="sidebar">
								<!-- Sidebar -->
								<!-- Recent Posts -->
								<tiles:insertAttribute name="left-navigation" />
								<!-- /Recent Posts -->
								<!-- /Sidebar -->
							</div>
						</div>

						<!-- Content -->
						<div class="8u skel-cell-important">
						
							<tiles:insertAttribute name="content" />
						</div>
					</div>
		
			</div>
		</div>
	</div>





	<!-- Footer -->
	<!-- Copyright -->
	<div id="copyright" class="container">
		<ul class="links">
			<li>&copy;2013 Digital Innovation Group</li>
			
		</ul>
	</div>
</body>
</html>