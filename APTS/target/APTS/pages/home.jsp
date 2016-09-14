<%--
  Created by IntelliJ IDEA.
  User: RuanJH
  Date: 2015/11/24
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <LINK rel="Bookmark" href="/favicon.ico"  >
  <LINK rel="Shortcut Icon" href="/favicon.ico" />

  <link href="../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="../resources/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
  <link href="../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />

  <title>后台登录</title>

</head>
<body>
<header class="Hui-header cl">
  <ul class="Hui-userbar">
    <li>用户</li>
    <li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">${admin.username} <i class="Hui-iconfont">&#xe6d5;</i></a>
      <ul class="dropDown-menu radius box-shadow">
        <li><a href="/getAdminById.do?id=${admin.userId}">个人信息</a></li>
        <li><a href="/pages/login.jsp">退出</a></li>
      </ul>
    </li>
  </ul>
  <a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> </header>
<aside class="Hui-aside">
  <input runat="server" id="divScrollValue" type="hidden" value="" />
  <div class="menu_dropdown bk_2" id="menu_dropdown">
      <dl id="menu-product">
        <dt><i class="Hui-iconfont">&#xe620;</i> 产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <li><a _href="/getAllProduct.do?all=1" href="javascript:void(0);">产品列表</a></li>
          </ul>
        </dd>
      </dl>
    <c:if test="${admin.ismanager!=0||admin.role==0}">
      <dl id="menu-corporation">
        <dt><i class="Hui-iconfont">&#xe643;</i> 企业管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <c:if test="${admin.role!=0}">
            <li><a _href="toupdateCorpotation.do?corpId=${admin.corpId}" href="javascript:void(0);">我的企业</a></li>
            <li><a _href="getAllDetector.do" href="javascript:void(0);">检测机构</a></li>
            </c:if>
            <c:if test="${admin.role==0}">
              <li>
              <a onclick="showCorp_list()" href="javascript:void(0);">企业列表<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></a>
              <ul id="corp_list">
                  <li><a _href="getAllCorporationInfo.do?role=1" href="javascript:void(0);">生产商</a></li>
                  <li><a _href="getAllCorporationInfo.do?role=2" href="javascript:void(0);">存储商</a></li>
                  <li><a _href="getAllCorporationInfo.do?role=3" href="javascript:void(0);">流通商</a></li>
                  <li><a _href="getAllCorporationInfo.do?role=4" href="javascript:void(0);">销售商</a></li>
                  <li><a _href="getAllDetector.do" href="javascript:void(0);">检测机构</a></li>
              </ul>
            </li>
            </c:if>
          </ul>
        </dd>
      </dl>
    </c:if>
    <c:if test="${admin.role==0||admin.role==1}">
      <dl id="menu-pesticide">
        <dt><i class="Hui-iconfont">&#xe626;</i> 农药管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <li><a _href="getAllPesticide.do" href="javascript:void(0);">农药列表</a></li>
          </ul>
        </dd>
      </dl>
    </c:if>
    <c:if test="${admin.role==0||admin.role==1}">
      <dl id="menu-fertilizer">
        <dt><i class="Hui-iconfont">&#xe626;</i> 化肥管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <li><a _href="getAllFertilizer.do" href="javascript:void(0);">化肥列表</a></li>
          </ul>
        </dd>
      </dl>
    </c:if>
      <dl id="menu-invitationcode">
        <dt><i class="Hui-iconfont">&#xe607;</i> 邀请码管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <li><a _href="getAllInvitationcode.do" href="javascript:void(0);">邀请码列表</a></li>
          </ul>
        </dd>
      </dl>
    <c:if test="${admin.ismanager!=0||admin.role==0}">
      <dl id="menu-file">
        <dt><i class="Hui-iconfont">&#xe63e;</i> 文件管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <li><a _href="getFilesbyCorpId.do?corpId=${admin.corpId}" href="javascript:void(0);">文件列表</a></li>
          </ul>
        </dd>
      </dl>
    </c:if>
    <c:if test="${admin.role==0||admin.role==1}">
      <dl id="menu-tools">
        <dt><i class="hui-iconfont">&#xe61d;</i> 工具<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
        <dd>
          <ul>
            <li><a _href="/pages/generateQRcode.html" href="javascript:void(0);">二维码生成</a></li>
          </ul>
        </dd>
      </dl>
    </c:if>
    <c:if test="${admin.role==0}">
    <dl id="menu-admin">
      <dt><i class="Hui-iconfont">&#xe60d;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
      <dd>
        <ul>
          <li><a _href="getAllAdmin.do" href="javascript:void(0)">用户列表</a></li>
        </ul>
      </dd>
    </dl>
    </c:if >
  </div>
</aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
  <div id="Hui-tabNav" class="Hui-tabNav">
    <div class="Hui-tabNav-wp">
      <ul id="min_title_list" class="acrossTab cl">
        <li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
      </ul>
    </div>
    <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
  </div>
  <div id="iframe_box" class="Hui-article">
    <div class="show_iframe">
      <div style="display:none" class="loading"></div>
      <iframe scrolling="yes" frameborder="0" src="/pages/welcome.html"></iframe>
    </div>
  </div>
</section>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script type="text/javascript" src="../resources/js/common.js"></script>

<script type="text/javascript">
  var dl = document.getElementById("menu_dropdown");
  var lis = dl.getElementsByTagName("li");
  var role=1;
  for (var x=0;x<lis.length;x=x+1) {
    if (role==role) {
      lis[x].setAttribute("class", "show");
    }
    else{
      lis[x].setAttribute("class", "hide");
    }
  }
</script>
</body>
</html>
