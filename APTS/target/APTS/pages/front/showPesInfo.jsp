<%--
  Created by IntelliJ IDEA.
  User: JLC
  Date: 2016/8/16
  Time: 下午 4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>农药信息</title>
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
  <label>农药名称：${Pesticide.pestName}</label>
</div>
<div>
  <label>农药厂商：${Pesticide.pestProd}</label>
</div>
<div>
  <label>农药功效：${Pesticide.pestEffect}</label>
</div>
<div>
  <label>农药成分：${Pesticide.pestElement}</label>
</div>
<div>
  <label>农药生产日期：${Pesticide.pestProdDate}</label>
</div>
<div>
  <label>农药有效日期：${Pesticide.pestLimitDate}</label>
</div>
<br/>
<p style="text-align: left">
  <a href="javascript:history.back(-1)">返回上一页</a>
</p>
</body>
</html>
