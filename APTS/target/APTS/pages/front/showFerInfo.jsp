<%--
  Created by IntelliJ IDEA.
  User: JLC
  Date: 2016/8/16
  Time: 下午 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>化肥信息</title>
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
  <label>化肥名称：${Fertilizer.fertName}</label>
</div>
<div>
  <label>化肥厂商：${Fertilizer.fertProd}</label>
</div>
<div>
  <label>化肥功效：${Fertilizer.fertEffect}</label>
</div>
<div>
  <label>化肥成分：${Fertilizer.fertElement}</label>
</div>
<div>
  <label>化肥生产日期：${Fertilizer.fertProdDate}</label>
</div>
<div>
  <label>化肥有效日期：${Fertilizer.fertLimitDate}</label>
</div>
<br/>
<p style="text-align: left">
  <a href="javascript:history.back(-1)">返回上一页</a>
</p>
</body>
</html>
