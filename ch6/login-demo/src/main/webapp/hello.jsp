<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/9/10
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1>hello</h1>
    <% System.out.println("hello"); %>
    <%!
    String getNowTimeStr(){
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    %>
    <div>
        当前时间：
        <%= this.getNowTimeStr() %>
    </div>
</head>
<body>

</body>
</html>
