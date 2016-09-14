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
  <title>产品列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
  <form action="/search.do" method="post" id="searchbycondition">
  <div class="text-l">
    <label>条件搜索：</label>
    <span class="select-box inline">
		<select id="type" name="type" class="select" required>
          <option value="0">类别</option>
          <option value="1">生产</option>
          <option value="2">存储</option>
          <option value="3">流通</option>
        </select>
	</span>
    <span class="select-box inline">
		<select id="corp" name="corp" class="select">
          <option value="0">企业</option>
 <%--         <c:forEach items="${corporationInfoList1}" var="corp" varStatus="status">
            <option value=${status.index+1}>${corp.name}</option>
          </c:forEach>--%>
        </select>
	</span>
        <span class="select-box inline">
		<select id="batch" name="batch" class="select">
          <option value="-1">批次</option>
          <c:forEach  var="batch" begin="1" end="100" varStatus="status">
            <option value=${status.index}>${status.index}</option>
          </c:forEach>
        </select>
	</span>
    日期范围：
    <input type="text"    onclick="WdatePicker()"  id="logmin"  name="logmin" class="input-text Wdate" style="width:120px;">
    - <input type="text"    onclick="WdatePicker()" onchange="compLog()" id="logmax" name="logmax" class="input-text Wdate" style="width:120px;">
    <a name="" class="btn btn-success" onclick="submitsearch()"> <i class="Hui-iconfont">&#xe665;</i> 搜索</a>
  </div>
  </form>
  <form action="/searchbyIden.do" method="post" id="search">
    <div class="text-l" STYLE="margin-top: 10px">
      <label>序列号搜索：</label>
      <input type="text" id="identifier" name="identifier"  placeholder=" 产品序列号" style="width:250px" class="input-text" required>
      <button name="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div>
  </form>
  <span><input  type = "radio" id="selectall" name = "selectall" onclick='window.location.href="/getAllProduct.do?all=1"'/>显示所有产品</span>
  <span><input  type = "radio" id="selectpart" name = "selectall"  onclick='window.location.href="/getAllProduct.do?all=0"'/>显示未完成录入产品</span>

  <form action="" method="post">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
      <c:if test="${role==0||role==1}">
      <span class="l" style="margin: 20px"><a href="/toaddProduct.do" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></span>
        </c:if>
      <c:if test="${role==0||role==2}">
        <span class="l" style="margin: 20px"><a href="javascript:void(0)" onclick="addstorage()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 录入存储信息</a></span>
      </c:if>
      <c:if test="${role==0||role==3}">
        <span class="l" style="margin: 20px"><a href="javascript:void(0)" onclick="addtransport()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 录入流通信息</a></span>
      </c:if>
      <c:if test="${role==0||role==4}">
        <span class="l" style="margin: 20px"><a href="javascript:void(0)" onclick="adddistribution()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 录入销售信息</a></span>
      </c:if>
      <span class="l"  style="margin: 20px"><a href="javascript:void(0)" onclick="delmulnews()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></span>
      <span class="r">共有数据：<strong>${productList.size()}</strong> 条</span>
    </div>
    <div class="mt-20">
      <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
          <th scope="col" colspan="9">产品列表</th>
        </tr>
        <tr class="text-c">
          <th width="25"><input type="checkbox" value="" name=""></th>
          <th width="80">ID</th>
          <th >产品序列号</th>
          <th>产品名称</th>
          <th>产地</th>
          <th >生产日期</th>
          <th >存储信息</th>
          <th >流通信息</th>
          <th >销售信息</th>
          <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product" varStatus="status">
          <tr class="text-c">
            <td><input type="checkbox" value="${product.productId}" name="box"></td>
            <td>${status.index+1}</td>
            <td>${product.identifier}</td>
            <td>${product.name}</td>
            <td>${product.seedSourProd}</td>
            <td>${product.produceTime}</td>
            <td>
              <c:if test="${product.isStored==1}"><a style="color: #008200">已录入</a></c:if>
              <c:if test="${product.isStored==0}"><a style="color: #cc0000">未录入</a></c:if>
            </td>
            <td>
              <c:if test="${product.isTransed==1}"><a style="color: #008200">已录入</a></c:if>
              <c:if test="${product.isTransed==0}"><a style="color: #cc0000">未录入</a></c:if>
            </td>
            <td>
              <c:if test="${product.isDisted==1}"><a style="color: #008200">已录入</a></c:if>
              <c:if test="${product.isDisted==0}"><a style="color: #cc0000">未录入</a></c:if>
            </td>
            <td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" href="/getProductById.do?id=${product.productId}"  title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" onclick="delconfirm(${product.productId})" class="ml-5" href="javascript:void(0)" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
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
<script type="text/javascript" src="../resources/js/product.js"></script>
<script type="text/javascript" src="../resources/js/addproduct.js"></script>
<script type="text/javascript" src="../resources/js/compDate.js"></script>
<script type="text/javascript">
  $(function(){
    $("#type").val("${type}");
    getcoprs("${type}","${corp}");
    $("#batch").val("${batch}");
    $("#logmin").val("${logmin}");
    $("#logmax").val("${logmax}");
    $("#identifier").val("${identifier}");
    if(${all==1}){
      $("#selectall").attr("checked","checked");
    }else $("#selectpart").attr("checked","checked");
  });

</script>
</body>
</html>