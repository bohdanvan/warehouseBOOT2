<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%--     eq ? ???????? ?? ?????????--%>
<%--?   ne ? ???????? ?? ???????????--%>
<%--?   lt ? ?????? ????? ???--%>
<%--?   gt ? ?????? ????? ???--%>
<%--?   le ? ?????? ???? ????? ????-??--%>
<%--?   ge ? ?????? ??? ????? ????-??--%>


<c:if test="${param.age gt 18}">
    The age is > 18 years!
</c:if>

<c:if test="${param.age lt 45}">
    The age is < 45 years!
</c:if>
<c:if test="${param.age gt 18}" var="boolVar">
    The age is > 18 years!
</c:if>
<c:if test="${boolVar}">
    The age is > 18 years again!
</c:if>


<c:choose>
    <c:when test="${param.x lt 5}">
        <b>x < 5</b>
    </c:when>
    <c:when test="${param.x lt 10}">
        x > 5 and x < 10
    </c:when>
    <c:otherwise>
        x > 10
    </c:otherwise>
</c:choose>


<%--ForEach--%>

<jsp:useBean id="test" class="prog.Test" />
<c:set var="list" value="${test.list}" />
<c:forEach items="${list}" var="s">
    <h1>
        <c:out value="${s}"/>
    </h1>
</c:forEach>


<table>
    <c:forEach items="${list}" var="s">
        <tr>
            <td><c:out value="${s.name}"/></td>
            <td><c:out value="${s.price}"/></td>
        </tr>
    </c:forEach>
</table>


<c:set var="str" value="Very very long string" />
<c:forTokens items="${str}" delims=" " var="token" begin="1" step="1">
    <h1>
        <c:out value="${token}"/>
    </h1>
</c:forTokens>

<c:if test="${param.r gt 20}">
    <c:redirect url="/JSTL" />
</c:if>

<c:catch var="ex">
    <% double x = 10/0; %>
</c:catch>
<c:if test="${ex ne null}">
    <c:out value="${ex.message}" />
</c:if>

<c:set var="string1" value="This is first String." />
<c:set var="string2" value="This is second String." />
<p>Length of String (1) : ${fn:length(string1)} </p>
<p>Length of String (2) : ${fn:length(string2)} </p>

<%--substring--%>
<c:set var="string1" value="${param.s}" />
<c:set var="string2" value="${fn:substring(string1, 0, 2)}" />
<c:out value="${string2}" />


<c:import var="data" url="http://www.tutorialspoint.com"/>
<c:out value="${data}"/>


<c:set var="ctx" value="${pageContext['request'].contextPath}"/>



<jsp:include page="<%= myVariable %>" flush="true" />

<jsp:include page="${myVariable}" flush="true" />

