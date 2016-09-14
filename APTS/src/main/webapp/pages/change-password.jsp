<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="../resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />

<title>修改密码</title>
</head>
<body>
<div class="pd-20">
	<h1>
		修改密码
	</h1>
	<form action="/changePassword.do" method="post" class="form form-horizontal" id="form-change-password">
		<input type="hidden" name="id" value="${admin.userId}">
		<div class="row cl">
			<label class="form-label col-2"><span>*</span>用户名：</label>
			<div class="formControls col-4"> ${admin.username} </div>
		</div>
		<input type="hidden" name="username" value="${admin.username}">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-4">
				<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="password" id="new-password" datatype="*6-18" ignore="ignore" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-4">
				<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="new-password2" id="new-password2" recheck="password" datatype="*6-18" errormsg="您两次输入的密码不一致！" ignore="ignore" >
			</div>
		</div>
		<div class="row cl">
			<div class="col-8 col-offset-2">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script>
$(function(){
	$("#form-change-password").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	});
	
});
</script>
</body>
</html>