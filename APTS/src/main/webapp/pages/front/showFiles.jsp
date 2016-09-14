<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2016/8/17
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>流通信息</title>
  <style type="text/css">
    body{color:black;}
    a:link{color:darkblue;}
    a:visited{color:darkblue;}
    a:hover{color:darkblue;}
    a:active{color:darkblue;}
  </style>

</head>
<body>
<div class="row cl">
  <label >文件：</label>
  <div >
    <table>
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

</body>
</html>
