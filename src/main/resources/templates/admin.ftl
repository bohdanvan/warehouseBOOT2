<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

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



                <!-- top tiles -->
                <div class="row tile_count">
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Users</span>
                        <div class="count">2500</div>
                        <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-clock-o"></i> Average Time</span>
                        <div class="count">123.50</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> From last Week</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Males</span>
                        <div class="count green">2,500</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Females</span>
                        <div class="count">4,567</div>
                        <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>12% </i> From last Week</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Collections</span>
                        <div class="count">2,315</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Connections</span>
                        <div class="count">7,325</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                    </div>
                </div>
                <!-- /top tiles -->



<#if incDel?exists>

                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">


                    <div class="x_panel">

                        <div class="x_title">
                            <h2>
                                customs declaration CN23
                            <#if id?exists>
                                <span th:if="${id} != null">
                        ${id} <span th:text="${id}">
                        </span>
                    </span>
                            </#if>
                            </h2>
                        <#if congratulation?exists>
                        ${congratulation}
                        </#if>

                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Settings 1</a>
                                        </li>
                                        <li><a href="#">Settings 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>  <!-- x-title -->

                        <div class="x_content">





                            <form method="POST" name="incDel" action="/incDel/new" class="form-horizontal ">  <!--form-label-left input_mask   th:object="${incDel}" th:action="@{/incDel/new}-->


                                <div class="row" style="margin-top:5px">
                                    <label class="control-label col-md-2 col-sm-2 col-xs-6">
                                        <a href="#" data-toggle="tooltip" title="
                                select the supplier of your product">
                                            <i class="fa fa-info-circle fa-1x" aria-hidden="true"></i></a>
                                        Supplier
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-6">

                                        <input type="text" class="form-control" required="required"
                                               placeholder="Supplier company name" name="supplier" th:field="*{supplier}"/>
                                    </div>

                                    <div class="col-md-4 col-sm-4 col-xs-6">
                                        <input type="text" class="form-control" required="required"
                                               placeholder="Currier Company delivery tracking number"
                                               name="currierTrackNumber"/>
                                    </div>
                                    <label class="col-md-2 col-sm-2 col-xs-6">Tracking
                                        <a href="#" data-toggle="tooltip" title="'
                                Important ! ">
                                            <i class="fa fa-info-circle fa-1x" aria-hidden="true"></i>
                                        </a>
                                    </label>
                                </div>


                                <div class="row" style="margin-top:5px">
                                    <label class="control-label col-md-2 col-sm-2 col-xs-6">
                                        <a href="#" data-toggle="tooltip" title="
                                Full adress your supplier">
                                            <i class="fa fa-info-circle fa-1x" aria-hidden="true"></i>
                                        </a>
                                        Adress
                                    </label>
                                    <div class="col-md-4 col-sm-4 col-xs-6">
                                        <input type="text" class="form-control" required="required"
                                               placeholder="City Street House Room">
                                    </div>

                                    <div class="col-md-4 col-sm-4 col-xs-6">
                                        <input type="text" class="form-control" required="required"
                                               placeholder="Invoice number from supplier" name="supplierInvoice"/>
                                    </div>
                                    <label class="col-md-2 col-sm-2 col-xs-6">Invoice
                                        <a href="#" data-toggle="tooltip" title="
                                Number invoice from suppler ">
                                            <i class="fa fa-info-circle fa-1x" aria-hidden="true"></i>
                                        </a></label>
                                </div>

                                <div class="ln_solid"></div>

                                <div class="row" style="margin-top:2%">

                                    <label class="col-md-2 text-right">
                                        <a href="#" data-toggle="tooltip" title="
                                Select the way how you want to send the goods">
                                            <i class="fa fa-info-circle fa-1x" aria-hidden="true"></i></a>
                                        &nbsp; Shipping Type :
                                    </label>

                                    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback text-center">


                                        <input type="radio" name="shippingType" value="air" checked="true"/>
                                        <i class="fa fa-plane fa-2x" aria-hidden="true"> </i> &nbsp;air&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="shippingType" value="sea"/>
                                        <i class="fa fa-ship fa-2x" aria-hidden="true"> </i>&nbsp;sea &nbsp;

                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="shippingType" value="land"/>
                                        <i class="fa fa-truck fa-2x" aria-hidden="true"></i>&nbsp;truck&nbsp;

                                    </div>

                                    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback text-center">

                                        <input type="radio" name="customsType" value="post" checked="true"/>
                                        <i class="fa fa-envelope fa-2x" aria-hidden="true"></i>&nbsp; Post &nbsp;

                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="customsType" value="official" disabled="true"/>
                                        <i class="fa fa-university fa-2x" aria-hidden="true"></i> &nbsp;Official&nbsp;


                                    </div>
                                    <label class="col-md-2">

                                        Customs Type : &nbsp;
                                        <a href="#" data-toggle="tooltip" title="
                                Please select the type of customs clearance">
                                            <i class="fa fa-info-circle fa-1x" aria-hidden="true"></i></a>
                                    </label>

                                </div>


                                <div class="ln_solid"></div>


                                <div class="container">

                                    <!-- Trigger the modal with a button -->
                                    <button type="button" class="btn btn-default btn-md" data-toggle="modal" data-target="#myModal">
                                        Add New Product
                                    </button>

                                    <a type="button" class="btn btn-default btn-md">Add Invoice</a>


                                    <div class="col-md-12 col-sm-12 col-xs-12">


                                    </div>


                                    <div class="table-responsive" style="margin-top:5px">
                                        <table class="table table-striped jambo_table bulk_action">
                                            <thead>
                                            <tr class="headings">
                                                <th>
                                                    <input type="checkbox" id="check-all" class="flat">
                                                    <input type="hidden" name="id"/>
                                                </th>


                                                <th class="column-title">productName</th>
                                                <th class="column-title">url</th>
                                                <th class="column-title">qty</th>
                                                <th class="column-title">price <i class="fa fa-usd" aria-hidden="true"></i>
                                                </th>
                                                <th class="column-title">Amount</th>
                                                <th class="column-title">Status</th>
                                                <th class="column-title no-link last"><span class="nobr">Action</span>
                                                </th>
                                                <th class="bulk-actions" colspan="7">
                                                    <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span
                                                            class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                                </th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <tr class="even pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="flat" name="table_records">
                                                </td>
                                                <td class=" ">Shoes</td>
                                                <td class=" ">www.amazon.com/%#@@232123</td>
                                                <td class=" ">2 </i></td>
                                                <td class=" "><i class="fa fa-usd" aria-hidden="true"></i>
                                                    340
                                                </td>
                                                <td class=" "><i class="fa fa-usd" aria-hidden="true"></i>
                                                    680
                                                </td>
                                                <td class="a-right a-right ">Paid</td>
                                                <td class="last">
                                                    <a href="#"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                                    <a href="#" style="margin-left: 10px"><i class="fa fa-trash-o"
                                                                                             aria-hidden="true"></i></a>

                                                </td>
                                            </tr>

                                            </tbody>
                                        </table>
                                    </div>


                                    <div class="ln_solid"></div>


                                    <div class="form-group">
                                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3" style="margin-top:1%">

                                            <input type="hidden" name="${_csrf.parameterName}"
                                                   value="${_csrf.token}" />

                                            <button type="reset" class="btn btn-primary">Cancel</button>
                                            <button type="submit" class="btn btn-success">Submit</button>
                                        </div>
                                    </div>

                                </div>
                            </form>


                        </div> <!-- x-content -->

                    </div>   <!-- x-panel -->


                </div>

            </div> <!--</row>-->



            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Add New Product Form</h4>
                        </div><!--modal-header-->

                        <div class="modal-body">


                            <form action="/product/new/">

                                <div class="row">
                                    <div class="form-group">

                                    </div>
                                    <label for="sel1" class="control-label col-md-2 col-sm-2 col-xs-6">Product </label>

                                    <div class="col-md-5 col-sm-4 col-xs-6">
                                        <select class="form-control" id="sel1">
                                            <option>Close</option>
                                            <option>Shoes</option>

                                        </select>
                                    </div>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input type="text" class="form-control" required="required"
                                               placeholder="qty" name="qty"/>
                                    </div>
                                    <div class="col-md-2 col-sm-2 col-xs-4">
                                        <input type="text" class="form-control" required="required"
                                               placeholder="usd" name="price"/>
                                    </div>


                                    <label for="url" class="control-label col-md-2 col-sm-2 col-xs-2"
                                           style="margin-top:2%">URL </label>
                                    <div class="col-md-10 col-sm-10 col-xs-10" style="margin-top:2%">
                                        <input id="url" type="text" class="form-control" required="required"
                                               placeholder=" enter the website link to your product " name="price"/>
                                    </div>

                                    <!--<a href="#" data-toggle="tooltip" title="add new product">-->
                                    <!--<i class="fa fa-info-circle fa-1x" aria-hidden="true"></i></a>-->
                                </div>
                                <br/>

                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default">Add</button>
                                    <button type="button" class="btn " data-dismiss="modal">Close</button>

                                </div>
                            </form>


                        </div>   <!--modal body end-->

                    </div>
                </div>

            </div>


        </div>
        <div class="col-lg-1 col-md-1 "></div>
    </div>
    <!--</div>-->


</#if>



<#--<#include "admin/incDel/${locale}.html">-->
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

