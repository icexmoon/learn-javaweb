<%--
  Created by IntelliJ IDEA.
  User: 70748
  Date: 2023/9/10
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
    <script type="text/javascript" src="/login-demo/js/axios-0.18.0.js"></script>
    <script type="text/javascript" src="/login-demo/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<h3>添加品牌</h3>
<form action="" method="post">
    品牌名称：<input name="brandName"><br>
    企业名称：<input name="companyName"><br>
    排序：<input name="ordered"><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
    状态：
    <input type="radio" name="status" value="1">禁用
    <input type="radio" name="status" value="0">启用<br>

    <input type="button" onclick="addBrand()" value="提交">
</form>
</body>
<script>
    function addBrand(){
        axios({
            method: "POST",
            url: "/login-demo/brand/add",
            data: {
                brandName: $("input[name='brandName']").val(),
                companyName: $("input[name='companyName']").val(),
                ordered: $("input[name='ordered']").val(),
                description: $("textarea[name='description']").html(),
                status: $("input[name='status']:checked").val()
            }
        }).then((resp)=>{
            if (resp.data.result){
                // 跳转到列表页
                document.location="/login-demo/brand/list";
            }
        });
    }
</script>
</html>
