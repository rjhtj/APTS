<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>用户查询界面</title>

  <!-- load stylesheets -->
  <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">                                                <!-- Bootstrap style -->
  <link rel="stylesheet" href="../../resources/css/flexslider.css">                                                   <!-- Flexslider style -->
  <link rel="stylesheet" href="../../resources/css/templatemo-style.css">                                             <!-- Templatemo style -->

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="page">

<!-- background images -->
<div class="page-bg-imgs-list">
  <img src="../../resources/images/img/background.jpg" id="page-1-img" class="main-img" alt="">
  <img src="../../resources/images/img/storage.jpg" id="page-2-img" alt="">
  <img src="../../resources/images/img/transport.jpg" id="page-3-img" alt="">
  <img src="../../resources/images/img/vegetable.jpg" id="page-4-img" alt="">
</div>

<div class="container-fluid">


  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-5 col-xl-5">

      <div class="header">

        <!-- site title -->
        <header class="box box-white">
          <a href="/pages/front/index_front.jsp" >
            <h1 class="box-text site-title-text">重新查询</h1>
          </a>
        </header>

        <!-- site navigation -->
        <nav class="js-nav">
          <ul class="nav-items-container">

            <li data-nav-item-id="page-1" class="block-keep-ratio block-keep-ratio-1-1 block-width-half box box-white box-nav-item js-nav-item pull-xs-left">
              <a href="/getProductInfo.do?id=${Product.productId}" target="rightblock" class="block-keep-ratio-content box-nav-item-link">
                <span class="box-text box-text-nav-item flexbox-center">生产信息</span>
              </a>
            </li>

            <li data-nav-item-id="page-2" class="block-keep-ratio block-keep-ratio-1-1 block-width-half box box-white box-nav-item js-nav-item pull-xs-right">
              <a href="/getStorageById.do?id=${Product.storageId}" target="rightblock" class="block-keep-ratio-content box-nav-item-link">
                <span class="box-text box-text-nav-item flexbox-center">存储信息</span>
              </a>
            </li>

            <li data-nav-item-id="page-3" class="block-keep-ratio block-keep-ratio-1-1 block-width-half box box-white box-nav-item js-nav-item pull-xs-left">
              <a href="/getTransportById.do?id=${Product.transportId}" target="rightblock" class="block-keep-ratio-content box-nav-item-link">
                <span class="box-text box-text-nav-item flexbox-center">流通信息</span>
              </a>
            </li>

            <li data-nav-item-id="page-4" class="block-keep-ratio block-keep-ratio-1-1 block-width-half box box-white box-nav-item js-nav-item pull-xs-right">
              <a href="/getDistributionById.do?id=${Product.distributionId}" target="rightblock" class="block-keep-ratio-content box-nav-item-link">
                <span class="box-text box-text-nav-item flexbox-center">销售信息</span>
              </a>
            </li>

            <li data-nav-item-id="page-4" class="block-keep-ratio block-keep-ratio-1-1 block-width-half box box-white box-nav-item js-nav-item pull-xs-left">
              <a href="/getCertificate.do?id=${Product.productId}" target="rightblock" class="block-keep-ratio-content box-nav-item-link">
                <span class="box-text box-text-nav-item flexbox-center">相关文件</span>
              </a>
            </li>
          </ul>
        </nav>
      </div> <!-- .header -->

    </div>



  </div>

  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-7 col-xl-7">
    <div class="content-wrapper js-content-wrapper">
      <!-- about -->

      <div class="box box-white margin-b-20" style="width:420px;height: 140px;">
        <h2 class="box-text page-title-text">产品相关信息</h2>
      </div>

      <div class="box box-white margin-b-20" style="width:420px; height: 420px;">
        <iframe name="rightblock" scrolling="yes" style="width:400px; height: 400px;" src="/getProductInfo.do?id=${Product.productId}">
        </iframe>
      </div>
    </div>
  </div>

  <!-- footer row -->
  <footer class="row footer js-footer">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

      <p class="copyright-text">Copyright &copy; 2016 MIPS246

      </p>

    </div>
  </footer>

</div>  <!-- .container-fluid -->

<div id="preloader">
  <div id="status">&nbsp;</div>
</div><!-- /#preloader -->

<!-- load JS files -->
<script src="../../resources/js/jquery-1.11.3.min.js"></script> <!-- jQuery -->
<script src="../../resources/js/jquery.flexslider-min.js"></script> <!-- Flex Slider -->
<script src="../../resources/js/jquery.backstretch.min.js"></script> <!-- Backstretch http://srobbin.com/jquery-plugins/backstretch/ -->
<script src="../../resources/js/templatemo-script.js"></script> <!-- Templatemo scripts -->

</body>
</html>