<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
<script src="http://code.angularjs.org/snapshot/angular.js"></script>



    <link rel="stylesheet" type="text/css" media="all"
          href="src/main/webapp/static/css/bootstrap.css" th:href="@{../css/bootstrap.css}"/>
    <link rel="stylesheet" type="text/css" media="all"
          href="/src/main/webapp/static/css/bootstrap.css" th:href="@{/css/bootstrap.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="/src/main/webapp/static/css/bootstrap.css" th:href="@{src/main/webapp/static/css/bootstrap.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="/src/main/webapp/static/css/bootstrap.css" th:href="@{src/main/webapp/static/css/bootstrap.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="bootstrap.css" th:href="@{bootstrap.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="bootstrap.css" th:href="@{/css/bootstrap.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="../static/bootstrap.css" th:href="@{/css/bootstrap.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="bootstrap.css" th:href="@{css/bootstrap.css}"/>

    <link href="../static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="bootstrap.css" rel="stylesheet" type="text/css"/>

    <link href="../static/css/core.css"
          th:href="@{/css/core.css}"
          rel="stylesheet" media="screen" />




    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/thvsjsp.css" th:href="@{/css/thvsjsp.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="static/css/bootstrap.min.css" th:href="@{static/css/bootstrap.min.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="../../css/bootstrap.min.css" th:href="@ {css/bootstrap.min.css}"/>

    <link href="${url}css/bootstrap.min.css" rel="stylesheet"type="text/css" media="all"
           th:href="@ {css/bootstrap.min.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="static/css/custom.css" th:href="@{static/css/custom.css }"/>



    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/custom.css" rel="stylesheet">
    <link href="../static/css/jquery.mCustomScrollbar.min.css" rel="stylesheet">
    <link href="../static/css/nprogress/nprogress.css" rel="stylesheet">

    <link href="${url}font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="${url}css/animate.css" rel="stylesheet">
    <link href="${url}css/custom.css" rel="stylesheet">
    <link href="${url}css/jquery.mCustomScrollbar.min.css" rel="stylesheet">
    <link href="${url}css/nprogress/nprogress.css" rel="stylesheet">

<#include "static/fonts.html">
<#include "static/cssTh.html">

</head>



<body class="login">




     <#include "login/${locale}.html">


</body>
</html>