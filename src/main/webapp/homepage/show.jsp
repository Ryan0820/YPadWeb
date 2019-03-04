<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>欢迎来到餐厅!</title>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script>
        $('#myButton').on('click', function () {
            var $btn = $(this).button('loading')
            // business logic...
            $btn.button('reset')
        })
    </script>
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
<div id="div1">

    <form action="" class="form-inline">
        <table border="1" class="table table-bordered table-hover">
            <c:forEach items="${pb.list}" var="food" varStatus="s">
                <div class="div2">
                    <div class="img-thumbnail">
                            <%--<img src="../img/xiaolongbao.jpg" alt="..." class="img-thumbnail"><br>--%>

                        <span id="name" class="food_name">${food.foodname}</span><br>

                        <span id="price" class="food_price">$ ${food.foodprice}</span><br>

                        <span class="food_type">简介:${food.foodtype}</span><br><br>

                        <a href="${pageContext.request.contextPath}/addToCartServlet?foodid=${food.foodid}">
                                <%-- <input class="btn btn-primary" type="submit" value="加入购物车"/>--%>
                            <button type="button" id="add" data-loading-text="Loading..." class="btn btn-primary"
                                    autocomplete="off">
                                加入购物车

                            </button>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </table>
    </form>


    <%--分页下标--%>
    <nav style="padding-left: 50px">
        <ul class="pagination">
            <c:if test="${pb.currentPage == 1}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != 1}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/listShowByPageBeanServlet?currentPage=${pb.currentPage -1}&rows=16"
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
                <c:if test="${i == pb.currentPage}">
                    <li class="active"><a
                            href="${pageContext.request.contextPath}/listShowByPageBeanServlet?currentPage=${i}&rows=16">${i}</a>
                    </li>
                </c:if>
                <c:if test="${i != pb.currentPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/listShowByPageBeanServlet?currentPage=${i}&rows=16">${i}</a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${pb.currentPage == pb.totalPage}">
            <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/listShowByPageBeanServlet?currentPage=${pb.currentPage + 1}&rows=16"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

</div>
<hr>
</body>
</html>
<%@include file="/footer.jsp" %>