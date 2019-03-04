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

        window.onload = function () {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除选中的数据吗？")) {
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("fid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("fid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;
                }
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
    <%--条件查询--%>
    <div id="selecttop">
        <form class="form-inline" action="${pageContext.request.contextPath}/findOneFoodServlet">
            <div class="form-group">
                <label for="exampleInputEmail2">请输入名称查询:</label>
                <input type="text" placeholder="请输入名称查询" value="${name}" name="foodname" class="form-control" id="exampleInputEmail2">
            </div>
            <input type="submit" class="btn btn-default" value="查询"/>
        </form>
    </div>
    <%--添加&多选删除--%>
    <div id="addUsers">
        <a class="btn btn-primary" href="../foodpage/foodadd.jsp">添加美食</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
    <%--表格内容--%>
    <form action="${pageContext.request.contextPath}/delCksbyidServlet" method="post" id="form">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <td><input type="checkbox" id="firstCb"></td>
                <th>编号</th>
                <%-- <th>美食ID</th>--%>
                <th>美食名</th>
                <th>美食分类</th>
                <th>美食价格</th>
                <th>美食备注</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${food}" var="food" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="fid" value="${food.foodid}"></td>
                    <td>${s.count}</td>
                        <%--<td>${food.foodid}</td>--%>
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
            </c:forEach>
        </table>
    </form>
    <%--分页下标--%>
   <%-- <nav>
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <li><a href="${pageContext.request.contextPath}/listFoodByPageBeanServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:forEach>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>--%>

</div>
</body>
</html>
<%@include file="/footer.jsp" %>