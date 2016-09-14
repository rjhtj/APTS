<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2016/8/17
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>生产商信息</title>
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
  <label>公司ID：${Producer.corpId}</label>
  <a href="/front/getCorporationInfoById.do?id=${Producer.corpId}">查询此公司</a>
</div>
<div>
  <label>生产商地图：${Producer.producerMap}</label>
</div>
<br/>
<p style="text-align: left">
  <a href="javascript:history.back(-1)">返回上一页</a>
</p>
</body>
</html>

