<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/10/16
  Time: 11:27
  To change this tReptlate use File | Settings | File TReptlates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../adpage/adHeader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">添加原料</h3>
    <form action="${pageContext.request.contextPath}/addReptServlet" method="post">
        <input type="hidden" id="Reptid" name="Reptid" value=""/>
        <%-- <div class="form-group">
            <label for="Reptid">原料ID:</label>
            <input type="text" class="form-control" id="Reptid" name="reptid"/>
        </div>--%>
        <div class="form-group">
            <label for="Reptname">原料名:</label>
            <input type="text" class="form-control" id="Reptname" name="reptname"/>
        </div>

        <div class="form-group">
            <label for="Reptsfz">原料价格(斤/元):</label>
            <input type="text" class="form-control" id="Reptsfz" name="reptprice"/>
        </div>
        <div class="form-group">
            <label for="Reptphone">库存量(斤):</label>
            <input type="text" class="form-control" id="Reptphone" name="reptnumber"/>
        </div>

        <div class="form-group">
            <label for="Reptday">供货商:</label>
            <input type="text" class="form-control" id="Reptday" name="gname"/>
        </div>
        <div class="form-group">
            <label for="Reptsal">供货商联系方式:</label>
            <input type="text" id="Reptsal" class="form-control" name="gphone"/>
        </div>

        <div class="form-group">
            <label for="Reptbon">供货商地址:</label>
            <input type="text" id="Reptbon" class="form-control" name="gaddress"/>
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
