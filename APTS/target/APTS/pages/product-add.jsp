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
  <title>添加产品</title>
</head>
<body>
<div class="pd-20">
    <form action="/addProduct.do" method="post" class="form form-horizontal" id="form-product-add">
      <div>
        生产信息
      </div>
      <div class="row cl">
        <label class="form-label col-1">基本信息：</label>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>产品名称：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="product.name" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>品种：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="product.varieties" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>品牌：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="product.brand" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>是否认证：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="product.isIdentified" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>产地：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="product.seedSourProd" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>生产企业：</label>
        <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectcorpName" name="selectcorpName" size="1" onchange="getcorpContent()" required>
                  <option value="0">请选择生产企业</option>
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
      <input type="hidden" id="corpId" name="producer.corpId" >

      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>是否转基因：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="product.isTransgene" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>生产日期：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" id="produceTime" name="product.produceTime" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>上市时间：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" id="marketDate" name="product.marketDate" onchange="compProMarDat()">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>有效期：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" id="limitDate" name="product.limitDate" onchange="compProLimDat()">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>产品批次：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="producer.batchNum" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>生产区卫星地图：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="producer.producerMap" required>
        </div>
      </div>

      <div class="row cl">
        <label class="form-label col-1">生产信息：</label>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>耕耙日期：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.plowDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>机械使用：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.machine" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>播种日期：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.seedDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>播种天气：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.seedWeather" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="plantMethod.c-red">*</span>育苗时间：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.growDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>育苗方式：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.growMethod" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>移栽时间：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.transDate" required>
        </div>
      </div>
      <div id="waterTime">
        <div class="row cl">
          <label class="form-label col-2"><span class="c-red">*</span>灌溉时间：</label>
          <div class="formControls col-10">
            <input type="text" class="input-text" onclick="WdatePicker()" name="waterDate" required>
          </div>
        </div>
      </div>
      <div class="row cl">
        <div class="from-label col-2"></div>
        <div class="formControls col-5">
          <input type="button" class="btn btn-primary radius Hui-iconfont" value="&#xe600; 添加灌溉时间"
                  onclick="addWaterTime()"/>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>灌溉方式：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.waterMethod" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="plantMethod.c-red">*</span>采收时间：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.gatherDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>采收方式：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.gatherMethod" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>农药：</label>
        <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectpestName" name="selectpestName" size="1" onchange="getpestContent()" required>
                  <option value="0">请选择农药</option>
                  <c:forEach items="${pesticideList}" var="pest" varStatus="status">
                    <option value=${status.index+1}>${pest.pestName}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectpestId" name="selectpestId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${pesticideList}" var="pest" varStatus="status">
                    <option value=${status.index+1}>${pest.pestId}</option>
                  </c:forEach>
                </select>
				</span> </div>
      </div>
      <input type="hidden" id="plantMethodpestId" name="plantMethod.pestId" >

      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>农药使用日期：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"   onclick="WdatePicker()" name="plantMethod.pestDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>农药使用方法：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.pestMethod" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>农药用量：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.pestAmount" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>化肥：</label>
        <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectfertName" name="selectfertName" size="1" onchange="getfertContent()" required>
                  <option value="0">请选择化肥</option>
                  <c:forEach items="${fertilizerList}" var="fert" varStatus="status">
                    <option value=${status.index+1}>${fert.fertName}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectfertId" name="selectfertId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${fertilizerList}" var="fert" varStatus="status">
                    <option value=${status.index+1}>${fert.fertId}</option>
                  </c:forEach>
                </select>
				</span> </div>
      </div>
      <input type="hidden" id="plantMethodfertId" name="plantMethod.fertId">
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>化肥使用日期：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  onclick="WdatePicker()" name="plantMethod.fertDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>化肥使用方法：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.fertMethod" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>化肥用量：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.fertAmount" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>包装时间：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.packDate" required>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>包装方式：</label>
        <div class="formControls col-10">
          <input type="text" class="input-text"  name="plantMethod.packMethod"  required>
        </div>
      </div>
      <div class="row cl">
        <div class="col-10 col-offset-2">
          <label>添加数量：</label><input type="text" name="amount" datatype="n" required  />
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
<script type="text/javascript" src="../resources/js/addproduct.js"></script>
<script type="text/javascript" src="../resources/js/compDate.js"></script>
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