<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
        function delReptId(id) {
            //用户安全提示
            if (confirm("您确定删除此条记录吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delReptServlet?reptid=" + id;
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
    <h3 style="text-align: center">仓库信息表</h3>
    <div id="selecttop">
        <form class="form-inline" action="${pageContext.request.contextPath}/findOneReptServlet">
            <%--<div class="form-group">
                <label for="exampleInputName2">名字:</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>--%>
            <div class="form-group">
                <label for="exampleInputEmail2">请输入原料名查询:</label>
                <input type="text" value="${rept.reptname}" name="reptname" class="form-control" id="exampleInputEmail2">
            </div>
            <input type="submit" class="btn btn-default" value="查询">
        </form>
    </div>
    <div id="addUsers">
        <a class="btn btn-primary" href="../reptpage/reptadd.jsp">添加记录</a>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>原料ID</th>
            <th>原料名</th>
            <th>原料单价(斤/元)</th>
            <th>库存量(斤)</th>
            <th>金额(元)</th>
            <th>供货商</th>
            <th>供货商联系方式</th>
            <th>供货商地址</th>

            <th>操作</th>
        </tr>
        <tr>
            <td>${rept.reptid}</td>
            <td>${rept.reptname}</td>
            <td>${rept.reptprice}</td>
            <td>${rept.reptnumber}</td>
            <td>${rept.reptnumber * rept.reptnumber}</td>
            <td>${rept.gname}</td>
            <td>${rept.gphone}</td>
            <td>${rept.gaddress}</td>
            <td>
                <a class="btn btn-default btn-sm"
                   href="${pageContext.request.contextPath}/updateFindByReptIdServlet?reptid=${rept.reptid}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="javascript:delReptId(${rept.reptid});">删除</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
<%@include file="/footer.jsp" %>