<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isELIgnored="false" %>
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
        function delOrderId(id) {
            //用户安全提示
            if (confirm("您确定删除此条记录吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delOrderServlet?orderid=" + id;
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
    <h3 style="text-align: center">订单管理表</h3>
    <%--条件查询--%>
    <div id="selecttop">
        <form class="form-inline" action="${pageContext.request.contextPath}/findbyidServlet">
            <div class="form-group">
                <label for="exampleInputEmail2">请输入订单编号查询:</label>
                <input type="text" value="${order.orderid}" placeholder="请输入订单编号查询" name="orderid" class="form-control"
                       id="exampleInputEmail2">
            </div>
            <input type="submit" class="btn btn-default" value="查询"/>
        </form>
    </div>
    <%--添加&多选删除--%>
    <div id="addUsers">
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
    <%--表格内容--%>
    <form action="${pageContext.request.contextPath}/delOrderByCkServlet" method="post" id="form">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <td><input type="checkbox" id="firstCb"></td>

                <th>序号</th>
                <th>订单编号</th>
                <th>订单日期</th>
                <th>订单内容</th>
                <th>订单价格</th>
                <th>打折优惠</th>
                <th>实付金额</th>
                <th>订单备注</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="order" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="fid" value="${order.orderid}"></td>
                    <td>${s.count}</td>
                    <td>${order.orderid}</td>
                    <td>${order.ordertime}</td>
                    <td width="200px">${order.ordername}</td>
                    <td>${order.orderprice}</td>
                    <td>${order.ordersale}</td>
                    <td>${order.orderpay}</td>
                    <td>${order.ordertype}</td>
                    <td>
                            <%--<a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/updateFindByOrderIdServlet?orderid=${Order.Orderid}">修改</a>&nbsp;--%>
                        <a class="btn btn-default btn-sm" href="javascript:delOrderId(${order.orderid});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <%--分页下标--%>
    <nav>
        <ul class="pagination">
            <c:if test="${pb.currentPage == 1}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != 1}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/listOrderByLimitServlet?currentPage=${pb.currentPage -1}&rows=6"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
                <c:choose>
                    <c:when test="${pb.currentPage < 4}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="6"></c:set>
                        <c:if test="${end > pb.totalPage}">
                            <c:set var="end" value="${pb.totalPage}"></c:set>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${pb.currentPage >= 4}">
                            <c:set var="begin" value="${pb.currentPage - 2}"></c:set>
                            <c:set var="end" value="${pb.currentPage + 3}"></c:set>

                            <c:if test="${end > pb.totalPage}">
                                <c:set var="end" value="${pb.totalPage}"></c:set>
                            </c:if>
                        </c:if>
                    </c:otherwise>
                </c:choose>
                <c:forEach begin="${begin}" end="${end}" var="i">
            <%--<c:forEach begin="1" end="${pb.totalPage}" var="i">--%>
                <c:if test="${i == pb.currentPage}">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/listOrderByLimitServlet?currentPage=${i}&rows=6">${i}</a>
                    </li>
                </c:if>
                <c:if test="${i != pb.currentPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/listOrderByLimitServlet?currentPage=${i}&rows=6">${i}</a>
                    </li>
                </c:if>


            </c:forEach>


            <c:if test="${pb.currentPage == pb.totalPage}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/listOrderByLimitServlet?currentPage=${pb.currentPage + 1}&rows=6"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">共${pb.totalCount}条数据共${pb.totalPage}页</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
<%@include file="/footer.jsp" %>