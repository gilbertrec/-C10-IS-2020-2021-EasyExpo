<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 05/01/2021
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>

<!-- LOADER -->
<div id="loader">
    <div class="position-center-center">
        <div class="ldr"></div>
    </div>
</div>

<!-- Wrap -->
<div id="wrap">

    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Area Fornitore"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>RICHIESTE DI PREVENTIVO</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">BLOG</li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Request List -->
        <section class="blog-list blog-list-3 padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="row" style="margin-left: 110px; margin-right: -110px">
                    <div class="col-md-9">

                        <!-- Article -->
                        <article>
                            <div class="row">
                                <div class="col-sm-7">
                                    <!-- Tittle -->
                                    <div class="post-tittle left"> <a href="#." class="tittle">The unique Chair By PAVSHOP</a>
                                        <!-- Post Info -->
                                        <span><i class="primary-color icon-user"></i> by admin</span> <span><i class="primary-color icon-calendar"></i> April 27, 2016</span> <span><i class="primary-color icon-bubble"></i> 05</span> <span><i class="primary-color icon-tag"></i> Furniture</span> </div>
                                    <!-- Post Content -->
                                    <div class="text-left">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. Nunc ornare pharetra dui, vitae auctor orci fringilla eget. Pellentesque in placerat felis. Etiam mollis venenatis luctus.

                                            Nunc at blandit neque, bibendum varius purus.</p>
                                        <a href="#." class="red-more">READ MORE</a> </div>
                                </div>
                            </div>
                        </article>

                        <!-- Pagination -->
                        <ul class="pagination in-center">
                            <li><a href="#"><i class="fa fa-angle-left"></i></a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

    <!-- About -->
    <section class="small-about padding-top-150 padding-bottom-150">
        <div class="container">

            <!-- Main Heading -->
            <div class="heading text-center">
                <h4>Cos'è EASYEXPO</h4>
                <p>La piattaforma EasyExpo è un sistema di comunicazione tra gli organizzatori di
                    eventi e i Fornitori di attrezzature, è un portale dove confrontare i vari
                    preventivi e poter essere in collegamento diretto con i vari Fornitori.</p>
            </div>

            <!-- Social Icons -->
            <ul class="social_icons">
                <li><a href="#."><i class="icon-social-facebook"></i></a></li>
                <li><a href="#."><i class="icon-social-twitter"></i></a></li>
            </ul>
        </div>
    </section>

</div>

<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>

</div>
</body>
</html>