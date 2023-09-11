<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/9/10
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>编辑品牌</title>
</head>
<body>
<h3>编辑品牌</h3>
<form action="/login-demo/brand/edit?id=${brand.id}" method="post">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态：
    <input type="radio" name="status" value="1" <c:if test="${brand.status==1}"> checked="checked" </c:if> >禁用
    <input type="radio" name="status" value="0" <c:if test="${brand.status==0}"> checked="checked" </c:if> >启用<br>

    <input type="submit" value="提交">
</form>
</body>
</html>
