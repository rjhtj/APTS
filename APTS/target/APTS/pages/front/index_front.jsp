<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">                                                <!-- Bootstrap style -->
    <link rel="stylesheet" href="../../resources/css/flexslider.css">                                                   <!-- Flexslider style -->
    <link rel="stylesheet" href="../../resources/css/templatemo-style.css">
    <link href="../../resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../../resources/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="../../resources/css/style.css" rel="stylesheet" type="text/css" />
    <link href="../../resources/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <script languaga="JavaScript">
        <%
            String exist=null;
            exist=(String)request.getAttribute("isExist");
        %>
        var k="<%=exist%>";
        if(k!=null&&k!="null"){
            window.alert("该产品不存在");
        }
    </script>
    <title>农产品追溯系统</title>
</head>
<body style="background-image: url(../../resources/images/img/background.jpg);">
<a href="/pages/login.jsp" class="btn btn-success radius size-L">后台登入</a>
<div class="box box-white" style="position: absolute;top: 40%;left: 40%;height: 30%;width: 50%;margin: -5% 0 0 -15%;">
    <div  style="position: absolute;top: 40%;left: 40%;height: 30%;width: 50%;margin: -5% 0 0 -15%;">
        <form action="/getProductByIden.do">
            <label STYLE="font-size: medium">输入序列号：</label>
            <input type="text" name="identifier" class="input-text size-M" required/>
            <button type="submit" class="btn btn-success radius size-L">查询</button>
        </form>
    </div>
</div>
</body>
</html>