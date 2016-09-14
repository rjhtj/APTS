<%--
  Created by IntelliJ IDEA.
  User: RuanJH
  Date: 2015/12/2
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
  <link href="../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <title>文件列表</title>
  <script type="text/javascript"language="JavaScript">
    function delconfirm(id,corpId){
      if(confirm("确定要删除吗？")){
        window.location.href="/delfile.do?id="+id+"&corpId="+corpId;
      }
    }
  </script>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 文件管理 <span class="c-gray en">&gt;</span> 文件列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
  <c:if test="${role!=0}">
  <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="/touploadCertificate.do?corpId=${corpId}" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 上传文件</a></span> <span class="r">共有数据：<strong>${list.size()}</strong> 条</span> </div>
  </c:if>
    <div class="mt-20">
      <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
          <th scope="col" colspan="9">文件列表</th>
        </tr>
        <tr class="text-c">
          <th width="25"><input type="checkbox" value="" name=""></th>
          <th width="80">ID</th>
          <th width="260">文件名</th>
          <c:if test="${role==0}">
          <th >所属企业</th>
          </c:if>
          <th width="170">上传时间</th>
          <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="file" varStatus="status">
          <tr class="text-c">
            <td><input type="checkbox" value="1" name=""></td>
            <td>${status.index+1}</td>
            <td>${file.name}</td>
            <c:if test="${role==0}">
            <td>${map.get(file.corpId)}</td>
            </c:if>
            <td>${file.uploadDate}</td>
            <td class="f-14 td-manage">
              <a style="text-decoration:none" class="ml-5" href="/tofileshow.do?path=${file.path}"  title="查看">
                <i class="Hui-iconfont">&#xe665;</i>
              </a>
              <a style="text-decoration:none" onclick="delconfirm(${file.certificateId},${file.corpId})" class="ml-5" href="javascript:void(0)" title="删除">
                <i class="Hui-iconfont">&#xe6e2;</i>
              </a>
              <a style="text-decoration:none" class="ml-5" href="/downloadFiles.do?id=${file.certificateId}"  title="下载">
                <i class="Hui-iconfont">&#xe640;</i>
              </a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>

</div>

</body>
</html>
