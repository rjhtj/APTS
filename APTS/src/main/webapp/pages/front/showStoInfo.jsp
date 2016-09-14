<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2016/8/17
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style type="text/css">
    body{color:black;}
    a:link{color:darkblue;}
    a:visited{color:darkblue;}
    a:hover{color:darkblue;}
    a:active{color:darkblue;}
  </style>
    <title>

    </title>
</head>
<body>
<div style="">
  <label>存储仓公司ID：${Storage.corpId}</label>
  <a href="/front/getCorporationInfoById.do?id=${Storage.corpId}">查询此存储商</a>
</div>
<div>
  <label>存储时间：${Storage.storeTime}</label>
</div>
<div>
  <label>存储方式：${Storage.storeMethod}</label>
</div>
<div>
  <label>批次：${Storage.batchNum}</label>
</div>
</body>
</html>
