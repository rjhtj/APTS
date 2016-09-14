<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2016/8/17
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>流通信息</title>
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
  <label>流通公司ID：${Transport.corpId}</label>
  <a href="/front/getCorporationInfoById.do?id=${Transport.corpId}">查询此流通商</a>
</div>
<div>
  <label>流通时间：${Transport.transDate}</label>
</div>
<div>
  <label>流通方式：${Transport.transMethod}</label>
</div>
<div>
  <label>流通数量：${Transport.transAmount}</label>
</div>
<div>
  <label>目的地：${Transport.destination}</label>
</div>
<div>
  <label>批次：${Transport.batchNum}</label>
</div>
</body>
</html>
