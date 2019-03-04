<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/10/16
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@include file="../adpage/adHeader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">添加美食</h3>
    <form action="${pageContext.request.contextPath}/addFoodServlet" method="post">
         <%--隐藏域--%>
      <%--   <input type="hidden" id="id" name="id" value="${emp.empid}">--%>
         <input type="hidden" id="foodid" name="foodid" value=""/>
        <%--<div class="form-group">
            <label for="foodid">美食ID:</label>
            <input type="text" class="form-control" id="foodid" name="foodid"/>
        </div>--%>
        <div class="form-group">
            <label for="foodname">美食名:</label>
            <input type="text" class="form-control" id="foodname" name="foodname"/>
        </div>

        <div class="form-group">
            <label for="foodsci">美食分类:</label>
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜" selected>豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜">粤菜</option>

                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>

                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
        </div>

        <div class="form-group">
            <label for="foodprice">美食价格:</label>
            <input  type="text" id="foodprice" class="form-control" name="foodprice"/>
        </div>

        <div class="form-group">
            <label for="foodtype">美食备注:</label>
            <input  type="text" id="foodtype" class="form-control" name="foodtype"/>
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
        </div>
    </form>
</div>


</body>
</html>
<%@include file="/footer.jsp" %>
