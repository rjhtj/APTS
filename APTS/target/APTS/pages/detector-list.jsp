<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <LINK rel="Bookmark" href="/favicon.ico" >
  <LINK rel="Shortcut Icon" href="/favicon.ico" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="lib/html5.js"></script>
  <script type="text/javascript" src="lib/respond.min.js"></script>
  <script type="text/javascript" src="lib/PIE_IE678.js"></script>
  <![endif]-->
  <link href="../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
  <link href="../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>检测机构</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 企业管理 <span class="c-gray en">&gt;</span>企业列表<span class="c-gray en">&gt;</span> 检测机构 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
  <form action="" method="post">
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="/pages/detector-add.jsp" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a></span> <span class="r">共有数据：<strong>${list.size()}</strong> 条</span> </div>
    <div class="mt-20">
      <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
          <th scope="col" colspan="9">检测机构</th>
        </tr>
        <tr class="text-c">
          <th width="25"><input type="checkbox" value="" name=""></th>
          <th width="80">ID</th>
          <th width="260">名称</th>
          <th width="170">地址</th>
          <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="detector" varStatus="status">
          <tr class="text-c">
            <td><input type="checkbox" value="1" name=""></td>
            <td>${status.index+1}</td>
            <td>${detector.name}</td>
            <td>${detector.address}</td>
            <td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" href="/getDetectorById.do?id=${detector.detectorId}"  title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" onclick="delconfirm(${detector.detectorId})" class="ml-5" href="javascript:void(0)" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </form>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script type="text/javascript">
  function delconfirm(id){
    if(confirm("确定要删除吗？")){
      window.location.href="/delDetector.do?id="+id;
    }
  }
</script>
</body>
</html>