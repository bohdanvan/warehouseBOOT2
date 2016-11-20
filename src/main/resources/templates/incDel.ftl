<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">


<#include "headGr.html">


<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/admin" class="site_title"><i class="fa fa-paw"></i> <span>Admin Panel</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile">
                    <div class="profile_pic">
                        <img src="images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>${principal}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>


            <#include "admin/sidebar/${locale}.html">


            </div>
        </div>


    <#include "admin/navigation/${locale}.html">



    <#--<#include "admin/content/incDel/${locale}.html">-->


        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2> <#if title?exists>${title}</#if></h2>

                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Employee</a>
                                </li>
                                <li><a href="#">Client 2</a>
                                </li>
                                <li><a href="#">User 2</a>
                                </li>

                            </ul>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>


                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">


                            <h1>Form Registration new Delivery</h1>


                            <form action="#" th:action="@{/incDel}" th:object="${incDelNewForm}" method="post">

                                <p>Number: <input type="text" th:field="*{currierTrackNumber}" /></p>
                                <p>Supplier: <input type="text" th:field="*{supplier}" /></p>

                                <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
                            </form>
                        <#--<#if error?exists>${error}</#if>-->
                        </div>

                        <div class="col-lg-12 text-center">
                            <h1>Result</h1>
                            <p th:text="'truck#: ' + ${incDelNewForm.currierTrackNumber}"/>
                            <p th:text="'id: ' + ${incDelNewForm.supplier}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>





    <#--/////////////////////////////////////////////////////////////////////////////////////////////// -->

    <#include "admin/footer/${locale}.html">


    </div>
</div>

<#include "static/scriptsGr.html">


</body>
</html>

