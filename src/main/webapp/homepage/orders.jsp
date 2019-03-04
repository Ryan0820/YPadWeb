<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>欢迎来到餐厅!</title>
    <style>
        #div1 {
            padding: 20px;
        }

        .img-thumbnail {
            width: 200px;
            height: 150px;
        }

        .food_price {
            align: center;
            font-size: 22px;
            font-family: 幼圆;
            color: #c12e2a;
            padding-left: 2px;
            padding-top: 2px;
        }

        .food_name {
            align: center;
            font-size: 18px;
            font-family: 幼圆;
            color: #080808;
            padding-left: 2px;
            padding-top: 2px;
        }

        .food_type {
            align: center;
            font-size: 13px;
            font-family: Consolas;
            color: #0f0f0f;
            width: 130px;
            padding-left: 2px;
            padding-top: 2px;
        }

        .btn_shopping {
            float: right;
            margin: 3px;
        }

        .div2 {
            margin-left: 10px;
            margin-top: 10px;
            margin-right: 10px;
            float: left;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 style="text-align: center">仓库信息表</h3>
    <div id="selecttop">
        <form class="form-inline" action="${pageContext.request.contextPath}/findOneReptServlet">
            <div class="form-group">
                <label for="exampleInputEmail2">请输入原料名查询:</label>
                <input type="text" placeholder="请输入原料名查询" name="reptname" class="form-control" id="exampleInputEmail2">
            </div>
            <input type="submit" class="btn btn-default" value="查询"></input>
        </form>
    </div>
    <div id="addUsers">
        <a class="btn btn-primary" href="../reptpage/reptadd.jsp">添加记录</a>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
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

        <c:forEach items="${pb.list}" var="rept" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${rept.reptid}</td>
                <td>${rept.reptname}</td>
                <td>${rept.reptprice}</td>
                <td>${rept.reptnumber}</td>
                <td>${rept.reptnumber * rept.reptprice}</td>
                <td>${rept.gname}</td>
                <td>${rept.gphone}</td>
                <td>${rept.gaddress}</td>
                <td>
                    <a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/updateFindByReptIdServlet?reptid=${rept.reptid}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:delReptId(${rept.reptid});">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>





<hr>
</body>
</html>
<%@include file="/footer.jsp" %>