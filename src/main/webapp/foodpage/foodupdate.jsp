<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/10/16
  Time: 10:41
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
    <h3 style="text-align: center;">修改美食信息</h3>
    <form action="${pageContext.request.contextPath}/updateFoodServlet" method="post">
        <div class="form-group">
            <label for="foodid">美食ID:</label>
            <input value="${food.foodid}" type="text" class="form-control" id="foodid" name="foodid" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="foodname">美食名:</label>
            <input value="${food.foodname}" type="text" class="form-control" id="foodname" name="foodname" readonly="readonly"/>
        </div>

        <div class="form-group">
            <label for="foodsci">美食分类:</label>

            <c:if test="${food.foodsci == '豫菜'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜" selected>豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜">粤菜</option>

                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>

                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '湘菜'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜" selected>湘菜</option>
                    <option value="粤菜">粤菜</option>

                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>

                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '粤菜'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜" selected>粤菜</option>
                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>
                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '欧美'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜" >粤菜</option>
                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美"selected>欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>
                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '日韩'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜">粤菜</option>
                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩" selected>日韩</option>
                    <option value="东南亚">东南亚</option>
                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '东南亚'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜">粤菜</option>
                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚" selected>东南亚</option>
                    <option value="汤粥">汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '汤粥'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜">粤菜</option>
                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>
                    <option value="汤粥" selected>汤粥</option>
                    <option value="水饮">水饮</option>
                </select>
            </c:if>
            <c:if test="${food.foodsci == '水饮'}">
                <select name="foodsci" id="foodsci" class="form-control">
                    <option value="豫菜">豫菜</option>
                    <option value="湘菜">湘菜</option>
                    <option value="粤菜">粤菜</option>
                    <option value="鲁菜">鲁菜</option>
                    <option value="欧美">欧美</option>
                    <option value="日韩">日韩</option>
                    <option value="东南亚">东南亚</option>
                    <option value="汤粥">汤粥</option>
                    <option value="水饮" selected>水饮</option>
                </select>
            </c:if>
        </div>

        <div class="form-group">
            <label for="foodprice">美食价格:</label>
            <input value="${food.foodprice}" type="text" id="foodprice" class="form-control" name="foodprice"/>
        </div>

        <div class="form-group">
            <label for="foodtype">美食备注:</label>
            <input value="${food.foodtype}" type="text" id="foodtype" class="form-control" name="foodtype"/>
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