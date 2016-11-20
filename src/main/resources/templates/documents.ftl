<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

<#include "static/cssTh.html">

<body>


<#if enter>

</#if>

<#include "navigation/navigationDoc.html">
<#include "headerDoc.html">

<#include "login/login.html">
<#include "login/${locale}.html">

<#include "contact/${locale}.html">

<#include "login/login.html">
<#include "login/${locale}.html">

<#include "static/scripts.html">

</body>
</html>