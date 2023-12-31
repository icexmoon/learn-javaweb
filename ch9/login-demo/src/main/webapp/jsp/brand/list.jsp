<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/login-demo/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/login-demo/js/axios-0.18.0.js"></script>
</head>
<body>
<h1>${username}，欢迎您</h1>
<a href="/login-demo/brand/add"><input type="button" value="新增"></a><br>
<hr>
<table id="brandsTable" border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <tr align="center" class="brandsRow" hidden="hidden">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="/login-demo/brand/edit?id=#" class="edit">修改</a>
            <a href="/login-demo/brand/delete?id=#" class="delete">删除</a></td>
    </tr>
</table>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        loadBrandsTable();
    });

    function loadBrandsTable() {
        let table = $("table#brandsTable");
        let demoRow = table.find("tr.brandsRow:first");
        // 获取品牌列表信息
        axios({
            "method": "POST",
            "url": "/login-demo/brand/list"
        })
        .then((resp)=>{
            let brands = resp.data;
            brands.map((brand)=>{
                let newRow = demoRow.clone();
                console.log(newRow);
                fillRowData(newRow, brand);
                table.find("tr:last").after(newRow);
            });
        });
    }

    function fillRowData(newRow, data){
        newRow.children("td:eq(0)").html(data.id);
        newRow.children("td:eq(1)").html(data.brandName);
        newRow.children("td:eq(2)").html(data.companyName);
        newRow.children("td:eq(3)").html(data.ordered);
        newRow.children("td:eq(4)").html(data.description);
        let status = "禁用";
        if (data.status == 0){
            status = "启用";
        }
        newRow.children("td:eq(5)").html(status);
        newRow.children("td:eq(6)").children("a.edit").attr("href","/login-demo/brand/edit?id="+data.id);
        newRow.children("td:eq(6)").children("a.delete").attr("href","/login-demo/brand/delete?id="+data.id);
        newRow.removeAttr("hidden");
    }
</script>
</html>
