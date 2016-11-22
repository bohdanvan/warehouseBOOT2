<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AZEMEX 24h delivery</title>

    <#include "static/cssROOT.html">
    <#include "static/fonts.html">


</head>



<body>

    <#include "root/navigation/${locale}.html">

    <#include "header.html">

    <#include "root/about/${locale}.html">

    <#include "portfolio.html">

    <#include "services.html">

    <#include "clientsS.html">

    <#include "root/contact/${locale}.html">

    <#include "footer.html">


    <#include "root/modal/truck/${locale}.html">
    <#include "root/modal/ship/${locale}.html">
    <#include "root/modal/plane/${locale}.html">

    <#include "static/scriptsGr.html">
    <#--<#include "static/scripts.html">-->
    <#include "static/javaScripts.html">

</body>
</html>



