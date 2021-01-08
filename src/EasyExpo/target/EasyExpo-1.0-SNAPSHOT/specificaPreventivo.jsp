<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 05/01/2021
  Time: 15:13
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
                <h4>THE unique CHAIR BY PAVSHOP</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">BLOg details</li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Quotation List -->
        <section class="blog-list blog-list-3 single-post padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">

                        <!-- Article -->
                        <article>
                            <!-- Title -->
                            <div class="post-tittle left"> <a href="#." class="tittle">Look Beautiful in this Seasons</a>
                                <!-- Post Info -->
                                <span><i class="primary-color icon-user"></i> by admin</span> <span><i class="primary-color icon-calendar"></i> April 27, 2016</span> <span><i class="primary-color icon-bubble"></i> 05</span> <span><i class="primary-color icon-tag"></i> Furniture</span> </div>
                            <!-- Post Content -->
                            <div class="text-left">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. Nunc ornare pharetra dui, vitae auctor orci fringilla eget. Pellentesque in placerat felis. Etiam mollis venenatis luctus. Morbi ac scelerisque mauris. Etiam sodales a nulla ornare viverra. Nunc at blandit neque, bibendum varius purus. <br>
                                    <br>
                                    Nam sit amet sapien vitae enim vehicula tincidunt. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc faucibus imperdiet vulputate. Morbi volutpat leo iaculis elit vehicula, eu convallis magna finibus. Suspendisse tristique ullamcorper erat a elementum. Cras eget elit non nunc aliquam ullamcorper quis sed metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada, erat in ullamcorper bibendum, elit lacus mattis lorem, quis luctus diam lorem vel ligula.</p>
                                <h6 class="margin-top-80 margin-bottom-30">proeduct history</h6>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. Nunc ornare pharetra dui, vitae auctor orci fringilla eget. Pellentesque in placerat felis. Etiam mollis venenatis luctus. Morbi ac scelerisque mauris. Etiam sodales a nulla ornare viverra. <br>
                                    <br>
                                    Nam sit amet sapien vitae enim vehicula tincidunt. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc faucibus imperdiet vulputate. Morbi volutpat leo iaculis elit vehicula, eu convallis magna finibus.  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada, erat in ullamcorper bibendum, elit lacus mattis lorem, quis luctus diam lorem vel ligula.</p>

                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. Nunc ornare pharetra dui, vitae auctor orci fringilla eget. Pellentesque in placerat felis. Etiam mollis venenatis luctus. Morbi ac scelerisque mauris. Etiam sodales a nulla ornare viverra. Nunc at blandit neque, bibendum varius purus. <br>
                                    <br>
                                    Nam sit amet sapien vitae enim vehicula tincidunt. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc faucibus imperdiet vulputate. Morbi volutpat leo iaculis elit vehicula, eu convallis magna finibus. Suspendisse tristique ullamcorper erat a elementum. Cras eget elit non nunc aliquam ullamcorper quis sed metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada, erat in ullamcorper bibendum, elit lacus mattis lorem, quis luctus diam lorem vel ligula.</p>

                                <!-- LIST STYLE -->
                                <ul class="list-group margin-top-50 margin-top-20">
                                    <li>
                                        <p>Donec sed dictum leo, et posuere felis. </p>
                                    </li>
                                    <li>
                                        <p> Sed pharetra mauris vel varius suscipit. Aliquam lectus velit, </p>
                                    </li>
                                    <li>
                                        <p> Tempus id est ut, volutpat maximus sapien. </p>
                                    </li>
                                </ul>
                                <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui aolutpat dui at lacus aliquet, a consequat et lacus aliquet, a consequat enim aliquet. Integer molestie sit ame.</p>

                                <!-- Blockquote -->
                                <blockquote>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. </blockquote>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. NullamMorbi ac scelerisque mauris. Etiam sodales a nulla ornare viverra. Nunc at blandit neque, bociis natoque penatibus et magnnascetiscing elit. NullamMorbi ac scelerisque miscing elit. NullamMorbi ac scelerisque mur ridic volutpat dui at lacus aliquet, a consequat enim aliquet. Integer molestie sit ame.</p>

                                <!-- Fornitore/cliente info da fare il choose a seconda di chi lo apre -->
                                <div class="admin-info">
                                    <div class="media-left">
                                        <div class="admin-pic"> <img src="images/admin-avatar.jpg" alt=""> </div>
                                    </div>
                                    <div class="media-body">
                                        <h6>NATASHA S. <span>Co-Founder</span></h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. NullamMorbi ac scelerisque mauris. Etiam sodales a nulla ornare viverra. Nunc at blandit neque, bociis natoque penatcing e scelerisque miscing elit. </p>
                                        <div class="admin-social"> <a href="#."><i class="icon-social-facebook"></i></a> <a href="#."><i class="icon-social-twitter"></i></a> <a href="#."><i class="icon-social-dribbble"></i></a> <a href="#."><i class="icon-envelope"></i></a> </div>
                                    </div>
                                </div>
                            </div>
                        </article>
                        <hr>

                    </div>

                    <!-- Sider Bar -->
                    <div class="col-md-3">
                        <div class="shop-sidebar">

                            <!-- Recent Post -->
                            <h5 class="shop-tittle margin-top-60 margin-bottom-30">recent post</h5>
                            <ul class="papu-post margin-top-20">
                                <li class="media">
                                    <div class="media-left"> <a href="#"> <img class="media-object" src="images/sm-post-1.jpg" alt=""></a> </div>
                                    <div class="media-body"> <a class="media-heading" href="#.">Nullam volutpat dui at
                                        a consequat enimiquet</a> <span>Posted on Sep 27</span> </div>
                                </li>
                                <li class="media">
                                    <div class="media-left"> <a href="#"> <img class="media-object" src="images/sm-post-2.jpg" alt=""></a> </div>
                                    <div class="media-body"> <a class="media-heading" href="#.">Nullam volutpat dui at
                                        a consequat enimiquet</a> <span>Posted on Sep 27</span> </div>
                                </li>
                                <li class="media">
                                    <div class="media-left"> <a href="#"> <img class="media-object" src="images/sm-post-3.jpg" alt=""></a> </div>
                                    <div class="media-body"> <a class="media-heading" href="#.">Nullam volutpat dui at
                                        a consequat enimiquet</a> <span>Posted on Sep 27</span> </div>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
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
