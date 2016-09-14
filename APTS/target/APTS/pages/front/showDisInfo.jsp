<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2016/8/17
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>经销商信息</title>
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
  <label>销售商公司ID：${Distribution.corpId}</label>
  <a href="/front/getCorporationInfoById.do?id=${Distribution.corpId}">查询此销售商</a>
</div>
<div>
  <label>客户：${Distribution.customer}</label>
</div>
<div>
  <label>销售时间：${Distribution.distributionTime}</label>
</div>
<div>
  <label>批次：${Distribution.batchNum}</label>
</div>
<div>
  <label>驳运方式：${Distribution.distributionMethod}</label>
</div>
</body>
</html>
