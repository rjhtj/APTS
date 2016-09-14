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
  <c:if test="${type==1}">
  <form action="/updateProduct_producer.do" method="post" class="form form-horizontal" id="form-product_producer-update">
    <div>
      生产信息
    </div>
    <div class="row cl">
      <label class="form-label col-1">基本信息：</label>
    </div>
    <input type="hidden"  name="product.productId" value="${product.productId}">
    <input type="hidden"  name="product.producerId" value="${product.producerId}">
    <input type="hidden"  name="product.plantMethodId" value="${product.plantMethodId}">
    <input type="hidden"  name="product.storageId" value="${product.storageId}">
    <input type="hidden"  name="product.transportId" value="${product.transportId}">
    <input type="hidden"  name="product.distributionId" value="${product.distributionId}">
    <input type="hidden"  name="product.isProded" value="${product.isProded}">
    <input type="hidden"  name="product.isDisted" value="${product.isDisted}">
    <input type="hidden"  name="product.isTransed" value="${product.isTransed}">
    <input type="hidden"  name="product.isStored" value="${product.isStored}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产品序列号：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.identifier" value="${product.identifier}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产品名称：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.name" value="${product.name}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>品种：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.varieties" value="${product.varieties}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>品牌：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.brand" value="${product.brand}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>是否认证：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.isIdentified" value="${product.isIdentified}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产地：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.seedSourProd" value="${product.seedSourProd}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产企业：</label>
      <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectprocorpName" name="selectprocorpName" size="1" onchange="getprocorpContent()" required>
                  <option value="0">${prod_corInfo.name}</option>
                  <c:forEach items="${producer_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.name}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectprocorpId" name="selectprocorpId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.corpId}</option>
                  </c:forEach>
                </select>
				</span> </div>
    </div>
    <input type="hidden" id="producercorpId" name="producer.corpId" value="${producer.corpId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>是否转基因：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="product.isTransgene" value="${product.isTransgene}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产日期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="product.produceTime" value="${product.produceTime}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>上市时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="product.marketDate" value="${product.marketDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>有效期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="product.limitDate" value="${product.limitDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>产品批次：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="producer.batchNum" value="${producer.batchNum}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>生产区卫星地图：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="producer.producerMap" value="${producer.producerMap}" required>
      </div>
    </div>

    <div class="row cl">
      <label class="form-label col-1">生产信息：</label>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>耕耙日期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.plowDate" value="${plantMethod.plowDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>机械使用：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.machine" value="${plantMethod.machine}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>播种日期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.seedDate" value="${plantMethod.seedDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>播种天气：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.seedWeather" value="${plantMethod.seedWeather}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>育苗时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.growDate" value="${plantMethod.growDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>育苗方式：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.growMethod" value="${plantMethod.growMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>移栽时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.transDate" value="${plantMethod.transDate}" required>
      </div>
    </div>
    <div id="waterTime">
      <c:forEach items="${waterDate}" var="date" varStatus="status">
        <div class="row cl">
          <label class="form-label col-2"><span class="c-red">*</span>灌溉时间：</label>
          <div class="formControls col-10">
            <input type="text" class="input-text" onclick="WdatePicker()" value="${date}" name="waterDate" required>
          </div>
        </div>
      </c:forEach>
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
        <input type="text" class="input-text"  name="plantMethod.waterMethod" value="${plantMethod.waterMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>采收时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.gatherDate" value="${plantMethod.gatherDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>采收方式：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.gatherMethod" value="${plantMethod.gatherMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药：</label>
      <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectpestName" name="selectpestName" size="1" onchange="getpestContent()" required>
                  <option value="0">${pesticide.pestName}</option>
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
    <input type="hidden" id="plantMethodpestId" name="plantMethod.pestId" value="${plantMethod.pestId}">

    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药使用日期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"   onclick="WdatePicker()" name="plantMethod.pestDate" value="${plantMethod.pestDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药使用方法：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.pestMethod" value="${plantMethod.pestMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>农药用量：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.pestAmount" value="${plantMethod.pestAmount}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥：</label>
      <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectfertName" name="selectfertName" size="1" onchange="getfertContent()" required>
                  <option value="0">${fertilizer.fertName}</option>
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
    <input type="hidden" id="plantMethodfertId" name="plantMethod.fertId" value="${plantMethod.fertId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥使用日期：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  onclick="WdatePicker()" name="plantMethod.fertDate" value="${plantMethod.fertDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥使用方法：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.fertMethod" value="${plantMethod.fertMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>化肥用量：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.fertAmount" value="${plantMethod.fertAmount}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>包装时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="plantMethod.packDate" value="${plantMethod.packDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>包装方式：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="plantMethod.packMethod" value="${plantMethod.packMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <div class="col-10 col-offset-2">
        <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
        <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
      </div>
    </div>
  </form>
  </c:if>
  <c:if test="${type==2}">
  <form action="/updateProduct_storage.do/${product.productId}" method="post" class="form form-horizontal" id="form-product_storage-update">
    <div>
      存储信息
    </div>
    <input type="hidden"  name="product.storageId" value="${product.storageId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>存储商：</label>
      <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectstorcorpName" name="selectstorcorpName" size="1" onchange="getstorcorpContent()" required>
                  <option value="0">${stor_corInfo.name}</option>
                  <c:forEach items="${storage_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.name}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectstorcorpId" name="selectstorcorpId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${storage_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.corpId}</option>
                  </c:forEach>
                </select>
				</span> </div>
    </div>
    <input type="hidden" id="storagecorpId" name="corpId" value="${storage.corpId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="batchNum" value="${storage.batchNum}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>存储时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="storeTime" value="${storage.storeTime}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>存储方式：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" name="storeMethod" value="${storage.storeMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <div class="col-10 col-offset-2">
        <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
        <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
      </div>
    </div>
  </form>
  </c:if>
  <c:if test="${type==3}">
  <form action="/updateProduct_transport.do/${product.productId}" method="post" class="form form-horizontal" id="form-product_transport-update">
    <div>
      流通信息
    </div>
    <input type="hidden"  name="product.transportId" value="${product.transportId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通商：</label>
      <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selecttranscorpName" name="selecttranscorpName" size="1" onchange="gettranscorpContent()" required>
                  <option value="0">${trans_corInfo.name}</option>
                  <c:forEach items="${transport_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.name}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selecttranscorpId" name="selecttranscorpId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${transport_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.corpId}</option>
                  </c:forEach>
                </select>
				</span> </div>
    </div>
    <input type="hidden" id="transportcorpId" name="corpId" value="${transport.corpId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="batchNum" value="${transport.batchNum}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="transDate" value="${transport.transDate}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通方式：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="transMethod" value="${transport.transMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>流通数量：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="transAmount" value="${transport.transAmount}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>目的地：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="destination" value="${transport.destination}" required>
      </div>
    </div>
    <div class="row cl">
      <div class="col-10 col-offset-2">
        <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
        <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
      </div>
    </div>
  </form>
  </c:if>
  <c:if test="${type==4}">
  <form action="/updateProduct_distribution.do/${product.productId}" method="post" class="form form-horizontal" id="form-product_distribution-update">
    <div>
      销售信息
    </div>
    <input type="hidden"  name="product.distributionId" value="${product.distributionId}">

    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>经销商：</label>
      <div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" id="selectdistcorpName" name="selectdistcorpName" size="1" onchange="getdistcorpContent()" required>
                  <option value="0">${dist_corInfo.name}</option>
                  <c:forEach items="${distribution_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.name}</option>
                  </c:forEach>
                </select>
				<select class="select" id="selectdistcorpId" name="selectdistcorpId" size="1">
                  <option value="0"></option>
                  <c:forEach items="${distribution_corporationInfoList}" var="corp" varStatus="status">
                    <option value=${status.index+1}>${corp.corpId}</option>
                  </c:forEach>
                </select>
				</span> </div>
    </div>
    <input type="hidden" id="distributioncorpId" name="corpId" value="${distribution.corpId}">
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>客户：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="customer" value="${distribution.customer}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>销售时间：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text" onclick="WdatePicker()" name="distributionTime" value="${distribution.distributionTime}" required>
      </div>
    </div>
    <div class="row cl">

      <label class="form-label col-2"><span class="c-red">*</span>批次：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="batchNum" value="${distribution.batchNum}" required>
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-2"><span class="c-red">*</span>驳运方式：</label>
      <div class="formControls col-10">
        <input type="text" class="input-text"  name="distributionMethod" value="${distribution.distributionMethod}" required>
      </div>
    </div>
    <div class="row cl">
      <div class="col-10 col-offset-2">
        <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
        <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
      </div>
    </div>
  </form>
  </c:if>
</div>
<script type="text/javascript" src="../resources/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../resources/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../resources/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../resources/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.js"></script>
<script type="text/javascript" src="../resources/js/H-ui.admin.js"></script>
<script type="text/javascript" src="../resources/js/updateproduct.js"></script>
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