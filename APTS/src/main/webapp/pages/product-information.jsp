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

  <title>产品信息</title>
</head>
<body>
<div class="pd-20">
  <c:if test="${product.isProded==1}">
  <div>
    生产信息<a style="font-size: 12px" onclick="showPro()">[展开]</a><a style="font-size: 12px; margin: 20px" onclick="updateinfo(${role}, ${product.productId}, 1)">编辑<i class="Hui-iconfont">&#xe6df;</i></a>
  </div>
  <form method="post" class="form form-horizontal" id="form-producer-info">
    <div class="row cl">
      <label class="form-label col-1">基本信息：</label>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产品序列号：</label>
        <div class="formControls col-4"> ${product.identifier} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产品名称：</label>
        <div class="formControls col-4"> ${product.name} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>品种：</label>
        <div class="formControls col-4"> ${product.varieties} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>品牌：</label>
        <div class="formControls col-4"> ${product.brand} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>是否认证：</label>
        <div class="formControls col-4"> ${product.isIdentified} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产地：</label>
        <div class="formControls col-4"> ${product.seedSourProd} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产企业：</label>
      <div class="formControls col-4"> ${prod_corInfo.name} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>是否转基因：</label>
          <div class="formControls col-4"> ${product.isTransgene} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>上市时间：</label>
        <div class="formControls col-4"> ${product.marketDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产日期：</label>
        <div class="formControls col-4"> ${product.produceTime} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>有效期：</label>
        <div class="formControls col-4"> ${product.limitDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产品批次：</label>
        <div class="formControls col-4"> ${producer.batchNum} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产区卫星地图：</label>
        <div class="formControls col-4"> ${producer.producerMap} </div>
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

    <div class="row cl">
      <label class="form-label col-1">生产信息：</label>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>耕耙日期：</label>
      <div class="formControls col-4"> ${plantMethod.plowDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>机械使用：</label>
      <div class="formControls col-4"> ${plantMethod.machine} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>播种日期：</label>
        <div class="formControls col-4"> ${plantMethod.seedDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>播种天气：</label>
        <div class="formControls col-4"> ${plantMethod.seedWeather} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>育苗时间：</label>
        <div class="formControls col-4"> ${plantMethod.growDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>育苗方式：</label>
        <div class="formControls col-4"> ${plantMethod.growMethod} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>移栽时间：</label>
        <div class="formControls col-4"> ${plantMethod.transDate} </div>
    </div>
    <c:forEach items="${waterDate}" var="date" varStatus="status">
      <div class="row cl">
        <label class="form-label col-2"><span class="c-red">*</span>第${status.index+1}次灌溉时间：</label>
        <div class="formControls col-4"> ${date} </div>
      </div>
    </c:forEach>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>灌溉方式：</label>
        <div class="formControls col-4"> ${plantMethod.waterMethod} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>采收时间：</label>
        <div class="formControls col-4"> ${plantMethod.gatherDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>采收方式：</label>
        <div class="formControls col-4"> ${plantMethod.gatherMethod} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药：</label>
      <div class="formControls col-4"> ${pesticide.pestName} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药使用日期：</label>
      <div class="formControls col-4"> ${plantMethod.pestDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药使用方法：</label>
      <div class="formControls col-4"> ${plantMethod.pestMethod} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药用量：</label>
      <div class="formControls col-4"> ${plantMethod.pestAmount} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥：</label>
      <div class="formControls col-4"> ${fertilizer.fertName} </div>
    </div>
    <input type="hidden" id="plantMethodfertId" name="plantMethod.fertId" value="${plantMethod.fertId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥使用日期：</label>
      <div class="formControls col-4"> ${plantMethod.fertDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥使用方法：</label>
      <div class="formControls col-4"> ${plantMethod.fertMethod} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥用量：</label>
      <div class="formControls col-4"> ${plantMethod.fertAmount} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>包装时间：</label>
      <div class="formControls col-4"> ${plantMethod.packDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>包装方式：</label>
      <div class="formControls col-4"> ${plantMethod.packMethod} </div>
    </div>
  </form>
  </c:if>
</div>

<div class="pd-20">
  <c:if test="${product.isStored==1}">
  <div>
    存储信息<a style="font-size: 12px" onclick="showStor()">[展开]</a><a style="font-size: 12px; margin: 20px" onclick="updateinfo(${role}, ${product.productId}, 2)">编辑<i class="Hui-iconfont">&#xe6df;</i></a>
  </div>
  <form method="post" class="form form-horizontal" id="form-storage-info">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>存储商：</label>
        <div class="formControls col-4"> ${stor_corInfo.name} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
        <div class="formControls col-4"> ${storage.batchNum} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>存储时间：</label>
        <div class="formControls col-4"> ${storage.storeTime} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>存储方式：</label>
      <div class="formControls col-4"> ${storage.storeMethod} </div>
    </div>
  </form>
  </c:if>
  <c:if test="${product.isStored==0}">
  <div>
    存储信息
  </div>
  待录入……
  </c:if>
</div>
<div class="pd-20">
  <c:if test="${product.isTransed==1}">
  <div>
    流通信息<a style="font-size: 12px" onclick="showTrans()">[展开]</a><a style="font-size: 12px; margin: 20px" onclick="updateinfo(${role}, ${product.productId}, 3)">编辑<i class="Hui-iconfont">&#xe6df;</i></a>
  </div>
  <form method="post" class="form form-horizontal" id="form-transport-info">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通商：</label>
        <div class="formControls col-4"> ${trans_corInfo.name} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
        <div class="formControls col-4"> ${transport.batchNum} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通时间：</label>
        <div class="formControls col-4"> ${transport.transDate} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通方式：</label>
        <div class="formControls col-4"> ${transport.transMethod} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通数量：</label>
        <div class="formControls col-4"> ${transport.transAmount} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>目的地：</label>
        <div class="formControls col-4"> ${transport.destination} </div>
    </div>
  </form>
  </c:if>
  <c:if test="${product.isTransed==0}">
    <div>
      流通信息
    </div>
    待录入……
  </c:if>
</div>
<div class="pd-20">
  <c:if test="${product.isDisted==1}">
  <div>
    销售信息<a style="font-size: 12px" onclick="showDist()">[展开]</a><a style="font-size: 12px; margin: 20px" onclick="updateinfo(${role}, ${product.productId}, 4)">编辑<i class="Hui-iconfont">&#xe6df;</i></a>
  </div>
  <form method="post" class="form form-horizontal" id="form-distribution-info">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>经销商：</label>
        <div class="formControls col-4"> ${dist_corInfo.name} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>客户：</label>
        <div class="formControls col-4"> ${distribution.customer} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>销售时间：</label>
      <div class="formControls col-4"> ${distribution.distributionTime} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
      <div class="formControls col-4"> ${distribution.batchNum} </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>驳运方式：</label>
      <div class="formControls col-4"> ${distribution.distributionMethod} </div>
    </div>
  </form>
    二维码：
    <div id="code"></div>
  </c:if>
  <c:if test="${product.isDisted==0}">
    <div>
      销售信息
    </div>
    待录入……
  </c:if>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../resources/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../resources/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script type="text/javascript" src="../resources/js/product.js"></script>
<script src="../resources/js/qrcode.js"></script>
<script src="../resources/js/table.js"></script>
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

  var qrcode = new QRCode("code", {
    width: 128,
    height: 128,
    colorDark : "#000000",
    colorLight : "#ffffff",
    correctLevel : QRCode.CorrectLevel.H
  });
  qrcode.makeCode("http://114.215.169.168:8080/getProductByIden.do?identifier=" + "${product.identifier}");

</script>
</body>
</html>