<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/9/12
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="/login-demo/css/register.css" rel="stylesheet">
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="/login-demo/user/login">登录</a>
    </div>
    <form id="reg-form" action="/login-demo/user/registry" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <c:if test="${errorMsg!=null}">
                        <span id="username_err" class="err_msg">${errorMsg}</span>
                    </c:if>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/login-demo/user/check_code">
                    <a href="#" id="changeImg" onclick="refreshCheckCode()">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
</body>
</html>
<script>
    // 刷新验证码
    function refreshCheckCode(){
        $("img#checkCodeImg").attr("src","/login-demo/user/check_code");
    }
</script>