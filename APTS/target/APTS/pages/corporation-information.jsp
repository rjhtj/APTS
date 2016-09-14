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
<link href="../resources/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="../resources/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>企业信息</title>
</head>
<body>
<div class="pd-20">
	<form method="post" class="form form-horizontal" id="form-corporatino-information">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>公司注册编号：</label>
				<div class="formControls col-4"> ${corporationInfo.registrationNum} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>公司名称：</label>
				<div class="formControls col-4"> ${corporationInfo.name} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>法人代表：</label>
				<div class="formControls col-4"> ${corporationInfo.representative} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>注册资金：</label>
				<div class="formControls col-4"> ${corporationInfo.registeredAssets} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>成立日期：</label>
				<div class="formControls col-4"> ${corporationInfo.setUpDate} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>行业领域：</label>
				<div class="formControls col-4"> ${corporationInfo.field} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>注册中心：</label>
				<div class="formControls col-4"> ${corporationInfo.registrationAuthority} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>地址：</label>
				<div class="formControls col-4"> ${corporationInfo.address} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>电话号码：</label>
				<div class="formControls col-4"> ${corporationInfo.telNum} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>相关网页：</label>
				<div class="formControls col-4"> ${corporationInfo.webUrl} </div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>是否审核：</label>
			<div class="formControls col-4">
			<c:if test="${corporationInfo.authentic==1}">是</c:if>
			<c:if test="${corporationInfo.authentic==0}">否</c:if></div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>文件：</label>
			<div class="formControls col-4">
				<table class="table table-border table-bordered table-bg">
					<tbody>
					<c:forEach items="${certificateList}" var="file" varStatus="status">
						<tr class="text-c">
							<td><a href="/tofileshow.do?path=${file.path}">${file.name}</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<c:if test="${corporationInfo.authentic==0}">
		<div class="row cl">
			<div class="col-9 col-offset-3">
		         <span class="l"><a href="/authentic.do?id=${corporationInfo.corpId}&role=${corporationInfo.role}" class="btn btn-primary radius"> 通过审核</a></span>
			</div>
		</div>
		</c:if>
	</form>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../resources/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../resources/lib/Validform/5.3.2/Validform.min.js"></script>
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