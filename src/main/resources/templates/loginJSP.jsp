<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%--<link href="<c:url value="/static/css/app.css" />" rel="stylesheet"--%>
	<%--type="text/css">--%>
<title>Spring Security </title>
</head>
<body class="security-app">
	<div class="details">
		<h2>Spring Security : ${msg}</h2>
		<a href="http://www.programming-free.com/2016/01/spring-security-spring-data-jpa.html" class="button green small">Tutorial</a> 
		<a href="https://github.com/priyadb/SpringSecurityJdbcApp/archive/master.zip"
			class="button red small">Download</a>
	</div>



	<%--Official documentation form--%>

	<c:url value="/log" var="loginUrl"/>
	<form action="${loginUrl}" method="post">
		<c:if test="${param.error != null}">
			<p>
				Invalid username and password.
			</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p>
				You have been logged out.
			</p>
		</c:if>
		<p>
			<label for="username">Username</label>
			<input type="text" id="username" name="username"/>
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"/>
		</p>
		<input type="hidden"
			   name="${_csrf.parameterName}"
			   value="${_csrf.token}"/>
		<button type="submit" class="btn">Log in</button>
	</form>



	This is ${tryLogginCount} attempt

	<br/>
	${error}

<div>======================================================================</div>


	<div> <br/> @Model : ${principal}
		<br/> username ${userName}
		<br/> getPrincipal ${getPrincipal}

		<br/> authReq_Name ${req_getName}
		<br/> authReq_getPrincipal ${req_getPrincipal}
		<br/> authReq_getCredentials ${req_getCredentials}

		<br/>am  :${am}
		<br/>request : ${r2}
		<br/>result  : ${res}
		<br/>result  : ${r3}
		<br/>httpServletRequest.authenticate(httpServletResponse)  : ${r4}

		<br/>httpServletRequest. changeSessionId : ${changeSessionId}
		<br/>httpServletRequest.getAuthType  : ${getAuthType}
		<br/>httpServletRequest. getContextPath : ${getContextPath}
		<br/>httpServletRequest. getCookies : ${getCookies}
		<br/>httpServletRequest. getMethod : ${getMethod}
		<br/>httpServletRequest.getPathInfo  : ${getPathInfo}
		<br/>httpServletRequest. getPathTranslated : ${getPathTranslated}
		<br/>httpServletRequest.getQueryString  : ${getQueryString}
		<br/>httpServletRequest.getRequestedSessionId  : ${getRequestedSessionId}
		<br/>httpServletRequest. isRequestedSessionIdFromCookie : ${isRequestedSessionIdFromCookie}
		<br/>httpServletRequest. isRequestedSessionIdFromURL : ${isRequestedSessionIdFromURL}
		<br/>httpServletRequest. isUserInRole("ADMIN") : ${isUserInRole}
		<br/>httpServletRequest. isUserInRole("USER") : ${isUserInRoleUser}
		<br/>httpServletRequest. isUserInRole("ROLE_ADMIN") : ${isUserInRoleROLE_ADMIN}
		<br/>httpServletRequest. isUserInRole("ROLE_USER") : ${isUserInRoleROLE_USER}
		<br/>httpServletRequest. isAsyncStarted : ${isAsyncStarted}
		<br/>httpServletRequest. isAsyncSupported : ${isAsyncSupported}
		<br/>httpServletRequest. isSecure : ${isSecure}
		<br/>httpServletRequest. getRemoteUser : ${getRemoteUser}
		<br/>httpServletRequest.getRequestURI  : ${getRequestURI}
		<br/>httpServletRequest. getRequestURL : ${getRequestURL}
		<%--<br/>httpServletRequest.  : ${r4}--%>
		<%--<br/>httpServletRequest.  : ${r4}--%>

		<br/>httpServletResponse : ${r5}
		<br/>httpSession : ${http}
		<br/>
	</div>

	<%--<form action="/login" method="post">--%>

		<%--<div class="lc-block">--%>
			<%--<div>--%>
				<%--<input type="text" class="style-4" name="username"--%>
					<%--placeholder="User Name" />--%>
			<%--</div>--%>
			<%--<div>--%>
				<%--<input type="password" class="style-4" name="password"--%>
					<%--placeholder="Password" />--%>
			<%--</div>--%>
			<%--<div>--%>
				<%--<input type="submit" value="Sign In" class="button red small" />--%>
			<%--</div>--%>
			<%--<c:if test="${param.error ne null}">--%>
				<%--<div class="alert-danger">Invalid username and password.</div>--%>
			<%--</c:if>--%>
			<%--<c:if test="${param.logout ne null}">--%>
				<%--<div class="alert-normal">You have been logged out.</div>--%>
			<%--</c:if>--%>
		<%--</div>--%>
		<%--<input type="hidden" name="${_csrf.parameterName}"--%>
			<%--value="${_csrf.token}" />--%>
	<%--</form>--%>



	<%--<form name='f' action="<c:url value='j_spring_security_check'/>" method='POST'>--%>
	<%--<p>--%>
	<%--<label for="username">Username</label>--%>
	<%--<input type="text"  name="j_username"/>--%>
	<%--</p>--%>
	<%--<p>--%>
	<%--<label for="password">Password</label>--%>
	<%--<input type="password"  name="j_password"/>--%>
	<%--</p>--%>
	<%--<input type="hidden"--%>
	<%--name="${_csrf.parameterName}"--%>
	<%--value="${_csrf.token}"/>--%>
	<%--<button type="submit" class="btn">Log in</button>--%>
	<%--</form>--%>



</body>
</html>



