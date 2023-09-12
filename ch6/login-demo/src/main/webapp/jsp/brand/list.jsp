<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>${username}，欢迎您</h1>
<a href="/login-demo/brand/add"><input type="button" value="新增"></a><br>
<hr>
<table border="1" cellspacing="0" width="800">
  <tr>
    <th>序号</th>
    <th>品牌名称</th>
    <th>企业名称</th>
    <th>排序</th>
    <th>品牌介绍</th>
    <th>状态</th>
    <th>操作</th>
  </tr>
<c:forEach items="${brands}" var="b">
  <tr align="center">
    <td>${b.id}</td>
    <td>${b.brandName}</td>
    <td>${b.companyName}</td>
    <td>${b.ordered}</td>
    <td>${b.description}</td>
    <td>
      <c:if test="${b.status==0}">
        启用
      </c:if>
      <c:if test="${b.status==1}">
        禁用
      </c:if>
    </td>
    <td><a href="/login-demo/brand/edit?id=${b.id}">修改</a>
      <a href="/login-demo/brand/delete?id=${b.id}">删除</a></td>
  </tr>
</c:forEach>
</table>
</body>
</html>
