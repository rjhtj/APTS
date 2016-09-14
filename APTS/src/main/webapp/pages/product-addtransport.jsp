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
  <title>录入流通信息</title>
</head>
<body>
<div class="pd-20">
    <form action="/addTransport.do" method="post" class="form form-horizontal" id="form-transport-add">
      <div>
        流通信息
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>流通商：</label>
        <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectcorpName" name="selectcorpName" size="1" onchange="getcorpContent()" required>
                  <option value="0">请选择流通商</option>
                  <c:forEach items="${corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.name}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectcorpId" name="selectcorpId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.corpId}</option>
                  </c:forEach>
                </select>
				</span> </div>
      </div>
      <input type="hidden" id="corpId" name="corpId" >

      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>流通时间：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="transDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>流通方式：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="transMethod" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>流通数量：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="transAmount" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>目的地：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="destination" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="batchNum" required>
        </div>
      </div>
      <input type="hidden"  name="list" value="${list}">
      <div class="row cl">
        <div class="col-10 col-offset-2">
          <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
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
<script type="text/javascript" src="../resources/js/addtransport.js"></script>
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
</script>
</body>
</html>