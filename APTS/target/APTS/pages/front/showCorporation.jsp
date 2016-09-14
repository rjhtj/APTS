<%--
  Created by IntelliJ IDEA.
  User: JLC
  Date: 2016/8/16
  Time: 下午 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公司信息</title>
  <style type="text/css">
    body{color:black;}
    a:link{color:darkblue;}
    a:visited{color:darkblue;}
    a:hover{color:darkblue;}
    a:active{color:darkblue;}
  </style>
</head>
<body>
<div>
  <label>公司注册编号：${CorporationInfo.registrationNum}</label>
</div>
<div>
  <label>公司名称：${CorporationInfo.name}</label>
</div>
<div>
  <label>法人代表：${CorporationInfo.representative}</label>
</div>
<div>
  <label>注册资金（元）：${CorporationInfo.registeredAssets}</label>
</div>
<div>
  <label>成立日期：${CorporationInfo.setUpDate}</label>
</div>
<div>
  <label>行业领域：${CorporationInfo.field}</label>
</div>
<div>
  <label>注册中心：${CorporationInfo.registrationAuthority}</label>
</div>
<div>
  <label>地址：${CorporationInfo.address}</label>
</div>
<div>
  <label>电话号码：${CorporationInfo.telNum}</label>
</div>
<div>
  <label>相关网页：${CorporationInfo.webUrl}</label>
</div>
<br/>
<p style="text-align: left">
  <a href="javascript:history.back(-1)">返回上一页</a>
</p>
</body>
</html>
