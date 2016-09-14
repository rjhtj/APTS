<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="lib/html5.js"></script>
  <script type="text/javascript" src="lib/respond.min.js"></script>
  <script type="text/javascript" src="lib/PIE_IE678.js"></script>
  <![endif]-->
  <link href="../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="../resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="../resources/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
  <link href="../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <link href="../resources/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>上传文件</title>
</head>
<body>
<div class="pd-20">
  <form action="" onsubmit="return check()" id="fileupload" enctype="multipart/form-data" method="post">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>报告名称：</label>
      <div class="formControls col-10">
        <input  type="text" class="input-text"  name="name" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>检测机构：</label>
      <div class="formControls col-10"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectdetector" name="selectdetector" size="1" onchange="getContent()" required>
                  <option value="0">请选择检测机构</option>
                  <c:forEach items="${list}" var="detector" varStatus="status">
                    <option value=${status.index+1}>${detector.name}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectdetectorId" name="selectdetectorId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${list}" var="detector" varStatus="status">
                    <option value=${status.index+1}>${detector.detectorId}</option>
                  </c:forEach>
                </select>
				</span>
      </div>
    </div>
    <input type="hidden" id="detectorId" name="detectorId" >
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>检测时间：</label>
      <div class="formControls col-10">
        <input  type="text" class="input-text"  onclick="WdatePicker()"  name="detectDate" required>
      </div>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
          <input type="hidden" value="" name="filename" id="filename">
          <input type="hidden" value="${corpId}" name="corpId" id="corpId">
          <label>上传文件：</label>
          <input  type="file"  name="uploadfile" id="uploadfile" />
<%--       <div>
          <input  type="submit" onclick="submitfile()" value="上传" />
       </div>--%>
    </div>

    <div class="row cl">
      <div class="col-10 col-offset-2">
        <button class="btn btn-primary radius" onclick="submitfile()" type="submit">上传</button>
        <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../resources/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../resources/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script type="text/javascript" src="../resources/js/files.js"></script>
<script type="text/javascript">
  $(function(){
    $('.skin-minimal input').iCheck({
      checkboxClass: 'icheckbox-blue',
      radioClass: 'iradio-blue',
      increaseArea: '20%'
    });

  });

  function mobanxuanze(){

  }
  function submitfile(){
            var str= document.getElementById("uploadfile").value;
            var s = str.split("\\");
            var file = s[s.length-1];
            document.getElementById("filename").setAttribute("value",file);
            document.getElementById("fileupload").action="/upload.do?method=uploadFile";
            document.getElementById("fileupload").submit();
          }
  function check(){
    //逻辑判断
    return false;//不允许表单提交
  }
</script>
</body>
</html>