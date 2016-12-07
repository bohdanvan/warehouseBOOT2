<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AZEMEX 24h delivery</title>

    <#include "static/cssROOTnew.html">
    <#include "static/fonts.html">


</head>



<body>

    <#include "root/navigation/${locale}.html">
    <#include "header.html">
    <#include "services.html">
    <#include "portfolio.html">
    <#include "root/about/${locale}.html">
    <#include "team.html">
    <#include "clientsS.html">
    <#include "root/contact/${locale}.html">
    <#include "footer.html">

    <#include "root/modal/truck/${locale}.html">
    <#--<#include "root/modal/ship/${locale}.html">-->
    <#--<#include "root/modal/plane/${locale}.html">-->


    <!-- scroll up -->
    <div class="scroll-bottom">
        <a href="#page-top">
            <img src="img/about/up-scroll.svg" class="scroll-up">
        </a>
    </div>


    <#include "static/scriptsNew.html">



    <script>
        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) {slideIndex = 1}
            if (n < 1) {slideIndex = slides.length}
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex-1].style.display = "block";
            dots[slideIndex-1].className += " active";
        }
    </script>

</body>
</html>



