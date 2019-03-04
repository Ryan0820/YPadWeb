<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/10/16
  Time: 10:41
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
    <h3 style="text-align: center;">修改仓库信息</h3>
    <form action="${pageContext.request.contextPath}/updateReptServlet" method="post">
        <div class="form-group">
            <label for="reptid">原料ID:</label>
            <input value="${rept.reptid}" type="text" class="form-control" id="reptid" name="reptid" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="Reptname">原料名:</label>
            <input value="${rept.reptname}" type="text" class="form-control" id="reptname" name="reptname"
                   readonly="readonly"/>
        </div>

        <div class="form-group">
            <label for="reptprice">原料价格(斤/元):</label>
            <input value="${rept.reptprice}" type="text" class="form-control" id="reptprice" name="reptprice"/>
        </div>
        <div class="form-group">
            <label for="reptnumber">库存量(斤):</label>
            <input value="${rept.reptnumber}" type="text" class="form-control" id="reptnumber" name="reptnumber"/>
        </div>

        <div class="form-group">
            <label for="gname">供货商:</label>
            <input value="${rept.gname}" type="text" class="form-control" id="gname" name="gname"/>
        </div>
        <div class="form-group">
            <label for="gphone">供货商联系方式:</label>
            <input value="${rept.gphone}" type="text" id="gphone" class="form-control" name="gphone"/>
        </div>

        <div class="form-group">
            <label for="gaddress">供货商地址:</label>
            <input value="${rept.gaddress}" type="text" id="gaddress" class="form-control" name="gaddress"/>
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