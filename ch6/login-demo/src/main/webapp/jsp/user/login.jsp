<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/9/12
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="/login-demo/css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/login-demo/user/login" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <c:if test="${errorMsg!=null}">
            <div id="errorMsg">${errorMsg}</div>
        </c:if>
        <p>Username:<input id="username" name="username" type="text" <c:if test="${cookie.username!=null}"> value="${cookie.username.value}"</c:if>></p>
        <p>Password:<input id="password" name="password" type="password" <c:if test="${cookie.password!=null}"> value="${cookie.password.value}"</c:if>></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox" <c:if test="${cookie.remember.value.equals('on')}"> checked="checked"</c:if>/></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="/login-demo/user/registry">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
