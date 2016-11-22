<#macro layout title record>

<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title> Azemex| ${title} ${record} </title>



    <link rel="stylesheet" type="text/css" media="all"
          href="../static/css/bootstrap.min.css" th:href="@{../css/bootstrap.min.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="../static/font-awesome/css/font-awesome.min.css" th:href="@{../css/font-awesome.min.css}"/>

    <link rel="stylesheet" type="text/css" media="all"
          href="../static/css/nprogress.css" th:href="@{../css/nprogress.css}"/>
    <link rel="stylesheet" type="text/css" media="all"
          href="../static/css/animate.min.css" th:href="@{../css/animate.min.css}"/>



    <link rel="stylesheet" type="text/css" media="all"
          href="../css/custom.min.css" th:href="@{../css/custom.min.css}"/>

    <



</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>




    <div class="login_wrapper">

        <div id="logIn" class="animate form login_form">

            <section class="login_content">
                <form action="/log" th:action="@{/log}"method="post" th:object="${user}">

                    <h1>${title}</h1>
                    <div>
                        <input name="userName" th:field="*{userName}" type="text" class="form-control" placeholder="login" required=""/>
                    </div>

                    <div>
                        <input type="password" th:field="*{password}" class="form-control" placeholder="Password" required=""/>
                    </div>

                    <div>

                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />


                        <button type="submit" class="btn btn-default submit">Log in</button>
                        <a class="reset_pass" href="/">Lost your password?</a>
                    </div>









                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">New to site?
                            <a href="#signup" class="to_register"> Create Account </a>
                        </p>

                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa fa-cube"></i> azemex</h1>
                            <p>©2016 All Rights Reserved. <a href="#">Privacy and Terms</a></p>
                        </div>
                    </div>
                </form>
            </section>
        </div>



        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form action="/user/new" th:action="@{/user/new}" th:object="${user}" method="post">
                    <h1>Create Account</h1>
                    <div>
                        <input name="username" th:field="*{userName}" type="text" class="form-control" placeholder="login" required=""/>
                    </div>
                    <div>
                        <input name="email" th:field="*{email}" type="email" class="form-control" placeholder="Email" required=""/>
                    </div>
                    <div>
                        <input type="password" th:field="*{password}" class="form-control" placeholder="Password" required=""/>
                    </div>
                    <div>
                        <input name ="passwordRepit" type="password" class="form-control" placeholder="Repit Password" required=""/>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-default submit">Submit</button>
                    </div>

                    <!--<span th:if="${student.gender} == 'M'" th:text="Male" />-->
                    <!--<span th:unless="${student.gender} == 'M'" th:text="Female" />-->


                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="#signin" class="to_register toLogIn"> Log in </a>
                            <!--<a href="#" class="toLogIn"> | password recovery </a>-->
                        </p>


                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa fa-cube"></i> azemex </h1>
                            <p>©2016 All Rights Reserved. <a href="#">Privacy and Terms</a></p>
                        </div>
                    </div>
                </form>
            </section>

        </div>





    </div>
</div>




</body>
</html>

</#macro>


