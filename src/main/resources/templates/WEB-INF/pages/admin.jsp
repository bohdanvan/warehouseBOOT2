<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>

	<title>${topTitle}</title>


	<%@include file='css.jsp'%>

</head>

<body class="nav-md">
<div class="container body">
	<div class="main_container">

		<%@include file='sideBar.jsp'%>
		<%@include file='topNavigation.jsp'%>

		<!-- page content -->
		<div class="right_col" role="main">
			<div class="">

                <div class="page-title">
					<div class="title_left">




					</div>
				</div>

                <%@include file="eng.jsp"%>

            </div>
		</div>
		<!-- /page content -->



		<%@include file='footer.jsp'%>
		<%@include file='js.jsp'%>




</body>
</html>






<%--<c:set var="url" value="../../"/>--%>
<%--<jsp:include page="${url}static/css/bootstrap.min.css" flush="true"/>--%>




















