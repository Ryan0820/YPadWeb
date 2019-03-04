<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../adpage/adHeader.jsp" %>
<html>
<head>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function delFoodId(id) {
            //用户安全提示
            if (confirm("您确定删除此条记录吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delFoodServlet?foodid=" + id;
            }
        }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }

        #addUsers {
            float: right;
            padding-right: 5px;
            padding-bottom: 5px;
        }

        #selecttop {
            float: left;
            padding-left: 5px;
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">美食信息表</h3>
    <div id="selecttop">
        <form class="form-inline" action="${pageContext.request.contextPath}/findOneFoodServlet">
            <div class="form-group">
                <label for="exampleInputEmail2">请输入美食名称查询:</label>
                <input type="text" value="${food.foodname}" placeholder="请输入名字查询" name="foodname" class="form-control" id="exampleInputEmail2">
            </div>
            <input type="submit"  class="btn btn-default" value="查询"></input>
        </form>
    </div>
    <div id="addUsers">
        <a class="btn btn-primary" href="../emppage/empadd.jsp">添加美食</a>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>美食ID</th>
            <th>美食名</th>
            <th>美食分类</th>
            <th>美食价格</th>
            <th>美食备注</th>

            <th>操作</th>
        </tr>
            <tr>
                <td>${food.foodid}</td>
                <td>${food.foodname}</td>
                <td>${food.foodsci}</td>
                <td>${food.foodprice}</td>
                <td>${food.foodtype}</td>
                <td>
                    <a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/updateFindByFoodIdServlet?foodid=${food.foodid}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:delFoodId(${food.foodid});">删除</a>
                </td>
            </tr>
    </table>
</div>
</body>
</html>
<%@include file="/footer.jsp" %>