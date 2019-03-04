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

        <c:forEach items="${rept}" var="rept" varStatus="s">
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

    <%--分页下标--%>


    <nav>
        <ul class="pagination">
            <c:if test="${pb.currentPage == 1}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != 1}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/listReptByPageBeanServlet?currentPage=${pb.currentPage -1}&rows=6"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%--
        用来进行中间页码的显示及使用超链接所带来的的问题的解决方案
        如何显示页码呢，我们其实只需要两个数据，begin和end就哦了，
        我们常见的百度页面有什么特点呢，你可以去看看我就不多说了；下面我给出他的计算公式：
            如果总页数<=10（列表长度），那么begin=1，end=总页数
            否则
            使用公式计算；begin=pc-5, end=pc + 4；
                两种特殊情况：
                头溢出：当begin<1时，让begin=1
                尾溢出：当end>${tp}时，让end=${tp}
     --%>
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
                <c:if test="${i == pb.currentPage}">
                    <li class="active"><a
                            href="${pageContext.request.contextPath}/listReptByPageBeanServlet?currentPage=${i}&rows=6">${i}</a>
                    </li>
                </c:if>
                <c:if test="${i != pb.currentPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/listReptByPageBeanServlet?currentPage=${i}&rows=6">${i}</a>
                    </li>
                </c:if>

            </c:forEach>
            <c:if test="${pb.currentPage == pb.totalPage}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/listReptByPageBeanServlet?currentPage=${pb.currentPage + 1}&rows=6"
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