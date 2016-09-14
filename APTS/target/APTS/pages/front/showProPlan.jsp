<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JLC
  Date: 2016/8/16
  Time: 下午 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>生产相关信息</title>
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
  <label>产品名称：${Product.name}</label>
</div>
<div>
  <label>品种：${Product.varieties}</label>
</div>
<div>
  <label>品牌：${Product.brand}</label>
</div>
<div>
  <label>是否认证：${Product.isIdentified}</label>
</div>
<div>
  <label>产地：${Product.seedSourProd}</label>
</div>
<div>
  <label>是否转基因：${Product.isTransgene}</label>
</div>
<div>
  <label>生产日期：${Product.produceTime}</label>
</div>
<div>
  <label>上市日期：${Product.marketDate}</label>
</div>
<div>
  <label>有效期：${Product.limitDate}</label>
</div>
<div>
  <label>产品批次：${Producer.batchNum}</label>
</div>
<div>
  <label><a href="/getPlantMethodById.do?id=${Product.plantMethodId}">生产方式查询</a></label>
</div>
<div>
  <label><a href="/getProducerById.do?id=${Product.producerId}">生产商查询</a></label>
</div>
</body>
</html>
