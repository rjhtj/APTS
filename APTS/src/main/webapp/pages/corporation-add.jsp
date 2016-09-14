<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <!--[if IE 6]>
  <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>企业注册</title>
</head>
<body>
<div class="pd-20">
  <form action="/addCorpotation.do" method="post" class="form form-horizontal" id="form-corporation-add" enctype="multipart/form-data">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>所属单位：</label>
      <div class="formControls col-10">
        <span class="select-box" style="width:150px;">
				<select class="select" id="corptype" name="corptype" size="1" required>
                  <option value="0">请选择公司类型</option>
                  <option value="1">生产商</option>
                  <option value="2">存储商</option>
                  <option value="3">流通商</option>
                  <option value="4">销售商</option>
                </select>
		</span>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>公司注册编号：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="registrationNum"  required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>公司名称：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="name"  required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>法人代表：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="representative" required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>注册资金（元）：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="registeredAssets"  required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>成立日期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="setUpDate"  required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>行业领域：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="field"  required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>注册中心：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="registrationAuthority" required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>地址：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="address"  required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>电话号码：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="telNum" required >
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>相关网页：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="webUrl" required >
      </div>
    </div>

    <div class="row cl">
      <label class="form-label col-2">文件：</label>
      <div class="formControls col-4">
        <table class="table table-border table-bordered table-bg" id="addfile">
          <thead>
          <tr class="text-c">
            <th width="260"><span class="c-red">*</span>文件名</th>
            <th width="170"></th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              <input  type="text" class="input-text"  name="filename" required>
            </td>
            <td>
              <label>上传文件：</label>
              <input  type="file"  name="uploadfile" id="uploadfile" />
            </td>
          </tr>
          </tbody>
        </table>
        <button  onclick="addfile()">添加文件</button>
      </div>
    </div>

    <div class="row cl">
      <div class="col-9 col-offset-3">
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

    $("#form-admin-add").Validform({
      tiptype:2,
      callback:function(form){
        form[0].submit();
        var index = parent.layer.getFrameIndex(window.name);
        parent.$('.btn-refresh').click();
        parent.layer.close(index);
      }
    });
  });

  function submitfile(){
    document.getElementById("form-corporation-add").submit();
  }
  function check(){
    //逻辑判断
    return false;//不允许表单提交
  }

  function addfile(){
    $("#addfile tbody").append(
            "<tr>" +
            "<td>" +
            '<input  type="text" class="input-text"  name="filename" required>' +
            "</td>" +
            "<td>"+
            "<label>上传文件：</label>" +
            '<input  type="file"  name="uploadfile" />' +
            "</td>"+
            "</tr>");
  }
</script>
</body>
</html>