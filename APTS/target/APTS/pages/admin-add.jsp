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
	<title>添加用户</title>
</head>
<body>
<div class="pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="用户名"  name="username" datatype="*2-16" nullmsg="用户名不能为空" required>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-5">
				<input type="password" placeholder="密码" autocomplete="off" name="password" class="input-text" datatype="*6-20" nullmsg="密码不能为空" required>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">用户类型：</label>
		     <div class="formControls col-5">
               <span class="select-box" style="width:150px;">
				<select class="select" id="selecttype" name="selecttype" size="1"  required>
					<option value="0">请选择用户类型</option>
					<option value="1">普通用户</option>
					<option value="2">管理员</option>
				</select>
               </span>
		     </div>
			</div>
		<div class="row cl">
			<label class="form-label col-3">所属单位：</label>
			<div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectcorpName" name="selectcorpName" size="1" onchange="getContent()" required>
					<option value="0">请选择所属单位</option>
					<c:forEach items="${corplist}" var="corp" varStatus="status">
						<option value=${status.index+1}>${corp.name}</option>
					</c:forEach>
				</select>
				<select class="select" id="selectcorpId" name="selectcorpId" size="1">
					<option value="0"></option>
					<c:forEach items="${corplist}" var="corp" varStatus="status">
						<option value=${status.index+1}>${corp.corpId}</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<input type="hidden" id="corpId" name="corpId" >
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<button class="btn btn-primary radius" onclick="admin_submit()"><i class="Hui-iconfont">&#xe632;</i> 保存并添加</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../resources/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script type="text/javascript" src="../resources/js/admin.js"></script>
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
</script>
</body>
</html>