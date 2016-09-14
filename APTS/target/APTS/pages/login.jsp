<%--
  Created by IntelliJ IDEA.
  User: RuanJH
  Date: 2015/11/24
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="lib/html5.js"></script>
  <script type="text/javascript" src="lib/respond.min.js"></script>
  <script type="text/javascript" src="lib/PIE_IE678.js"></script>
  <![endif]-->
  <link href="../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/H-ui.login.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
  <link href="../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>后台登录</title>

</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="/login.do" method="post" name="form1" id="form1">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="username" name="username" type="text" placeholder="账户" class="input-text size-L" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L" required>
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <button name="" onclick="check()" class="btn btn-success radius size-L">&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;</button>
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
        <a name="" onclick="register()" style="margin: auto">&nbsp;用户注册&nbsp;</a>
        <a name="" onclick="addcorp()" style="text-align: center">&nbsp;公司注册&nbsp;</a>
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 你的公司名称</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript">
  function register(){
    window.location.href="/pages/register.jsp";
  }
  function addcorp(){
    window.location.href="/pages/corporation-add.jsp";
  }
</script>
</body>
</html>