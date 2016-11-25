<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      ng-app="admin">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin panel </title>



<#include "static/cssAdmin.html">

</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col menu_fixed">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/admin" class="site_title"><i class="fa fa-cube" aria-hidden="false"></i>
                        <span>AZEMEX</span></a>

                </div>

                <div class="clearfix"></div>

            <#--<!-- menu profile quick info &ndash;&gt;-->
            <#--<div class="profile">-->
            <#--<div class="profile_pic">-->
            <#--<img src="../../webapp/static/img/img.JPG" alt="..." class="img-circle profile_img">-->
            <#--</div>-->
            <#--<div class="profile_info">-->
            <#--<span>Welcome,</span>-->
            <#--<h2>${principal}</h2>-->
            <#--</div>-->
            <#--</div>-->
            <#--<!-- /menu profile quick info &ndash;&gt;-->

                <br/>

            <#include "admin/sidebar/${locale}.html">


            </div>
        </div>

    <#include "admin/navigation/${locale}.html">





        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">


                    </div>
                </div>
                <!-- page content -->
            <#--=========================================================================================-->






<#include "admin/incDel/${locale}.html">
            <#--============================================================================================-->

            </div>
        </div>

        <!-- /page content -->






    <#include "admin/footer/${locale}.html">


    </div>
</div>



<#include "static/scriptsAdmin.html">


</body>
</html>

