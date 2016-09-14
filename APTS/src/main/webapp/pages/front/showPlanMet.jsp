<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JLC
  Date: 2016/8/16
  Time: 下午 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生产方式</title>
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
  <label>耕田日期：${PlantMethod.plowDate}</label>
</div>
<div>
  <label>机械使用：${PlantMethod.machine}</label>
</div>
<div>
  <label>播种日期：${PlantMethod.seedDate}</label>
</div>
<div>
  <label>播种天气：${PlantMethod.seedWeather}</label>
</div>
<div>
  <label>育苗时间：${PlantMethod.growDate}</label>
</div>
<div>
  <label>育苗方式：${PlantMethod.growMethod}</label>
</div>
<div>
  <label>移栽日期：${PlantMethod.transDate}</label>
</div>
<c:forEach items="${WaterDate}" var="date" varStatus="status">
  <div>
    <label>第${status.index+1}次灌溉日期：${date}</label>
  </div>
</c:forEach>
<div>
  <label>灌溉方式：${PlantMethod.waterMethod}</label>
</div>
<div>
  <label>采收时间：${PlantMethod.gatherDate}</label>
</div>
<div>
  <label>采收方式：${PlantMethod.gatherMethod}</label>
</div>
<div>
  <label>农药ID：${PlantMethod.pestId}</label>
  <a href="/front/getPesticideById.do?id=${PlantMethod.pestId}">查询此农药</a>
</div>
<div>
  <label>农药使用日期：${PlantMethod.pestDate}</label>
</div>
<div>
  <label>农药使用方式：${PlantMethod.pestMethod}</label>
</div>
<div>
  <label>农药用量：${PlantMethod.pestAmount}</label>
</div>
<div>
  <label>化肥ID：${PlantMethod.fertId}</label>
  <a href="/front/getFertilizerById.do?id=${PlantMethod.fertId}">查询此化肥</a>
</div>
<div>
  <label>化肥使用日期：${PlantMethod.fertDate}</label>
</div>
<div>
  <label>化肥使用方法：${PlantMethod.fertMethod}</label>
</div>
<div>
  <label>化肥用量：${PlantMethod.fertAmount}</label>
</div>
<div>
  <label>包装时间：${PlantMethod.packDate}</label>
</div>
<div>
  <label>包装方式：${PlantMethod.packMethod}</label>
</div>
<br/>
<p style="text-align: left">
  <a href="javascript:history.back(-1)">返回上一页</a>
</p>
</body>
</html>
