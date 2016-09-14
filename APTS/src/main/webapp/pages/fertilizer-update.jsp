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
  <title>更新信息</title>
</head>
<body>
<div class="pd-20">
  <form action="/updateFertilizer.do/${fertilizer.fertId}" method="post" class="form form-horizontal" id="form-fertilizer-update">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>名称：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="fertName" value="${fertilizer.fertName}" required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产企业：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" name="fertProd" value="${fertilizer.fertProd}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>功效：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="fertEffect" value="${fertilizer.fertEffect}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>配料：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="fertElement" value="${fertilizer.fertElement}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产日期：</label>
      <div class="formControls col-10">
        <input  type="text" class="input-text" onclick="WdatePicker()" name="fertProdDate" value="${fertilizer.fertProdDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>有效期：</label>
      <div class="formControls col-10">
        <input  type="text" class="input-text"  onclick="WdatePicker()"  name="fertLimitDate" value="${fertilizer.fertLimitDate}" required>
      </div>
    </div>
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