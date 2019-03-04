<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/10/16
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../adpage/adHeader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改员工信息</h3>
    <form action="${pageContext.request.contextPath}/updateEmpServlet" method="post">
        <%-- &lt;%&ndash;隐藏域&ndash;%&gt;
         <input type="hidden" id="id" name="id" value="${emp.empid}">--%>
        <div class="form-group">
            <label for="empid">员工工号:</label>
            <input value="${emp.empid}" type="text" class="form-control" id="empid" name="empid" readonly="readonly"/>
        </div>
        <div class="form-group">
            <label for="empname">员工姓名:</label>
            <input value="${emp.empname}" type="text" class="form-control" id="empname" name="empname"
                   readonly="readonly"/>
        </div>
        <div class="form-group">
            <label>员工性别：</label>
            <c:if test="${emp.empgender == '男'}">
                <input type="radio" name="empgender" value="男" checked/>男
                <input type="radio" name="empgender" value="女"/>女
            </c:if>
            <c:if test="${emp.empgender == '女'}">
                <input type="radio" name="empgender" value="男"/>男
                <input type="radio" name="empgender" value="女" checked/>女
            </c:if>
        </div>
        <div class="form-group">
            <label for="empsfz">员工身份证:</label>
            <input value="${emp.empsfz}" type="text" class="form-control" id="empsfz" name="empsfz"/>
        </div>
        <div class="form-group">
            <label for="empphone">员工联系方式:</label>
            <input value="${emp.empphone}" type="text" class="form-control" id="empphone" name="empphone"/>
        </div>
        <div class="form-group">
            <label for="empdept">员工部门:</label>

            <c:if test="${emp.empdept == '后厨'}">
                <select name="empdept" id="empdept" class="form-control">
                    <option value="后厨" selected>后厨</option>
                    <option value="保洁">保洁</option>
                    <option value="前台">前台</option>
                    <option value="安保">安保</option>
                    <option value="服务">服务</option>
                </select>
            </c:if>
            <c:if test="${emp.empdept == '保洁'}">
                <select name="empdept" id="empdept" class="form-control">
                    <option value="后厨">后厨</option>
                    <option value="保洁" selected>保洁</option>
                    <option value="前台">前台</option>
                    <option value="安保">安保</option>
                    <option value="服务">服务</option>
                </select>
            </c:if>
            <c:if test="${emp.empdept == '前台'}">
                <select name="empdept" id="empdept" class="form-control">
                    <option value="后厨">后厨</option>
                    <option value="保洁">保洁</option>
                    <option value="前台" selected>前台</option>
                    <option value="安保">安保</option>
                    <option value="服务">服务</option>
                </select>
            </c:if>
            <c:if test="${emp.empdept == '安保'}">
                <select name="empdept" id="empdept" class="form-control">
                    <option value="后厨">后厨</option>
                    <option value="保洁">保洁</option>
                    <option value="前台">前台</option>
                    <option value="安保" selected>安保</option>
                    <option value="服务">服务</option>
                </select>
            </c:if>
            <c:if test="${emp.empdept == '服务'}">
                <select name="empdept" id="empdept" class="form-control">
                    <option value="后厨">后厨</option>
                    <option value="保洁">保洁</option>
                    <option value="前台">前台</option>
                    <option value="安保">安保</option>
                    <option value="服务" selected>服务</option>
                </select>
            </c:if>
        </div>
        <div class="form-group">
            <label for="empday">员工出勤天数:</label>
            <input value="${emp.empday}" type="text" class="form-control" id="empday" name="empday"/>
        </div>
        <div class="form-group">
            <label for="empsal">员工工资:</label>
            <input value="${emp.empsal}" type="text" id="empsal" class="form-control" name="empsal"/>
        </div>

        <div class="form-group">
            <label for="empbon">员工奖金:</label>
            <input value="${emp.empbon}" type="text" id="empbon" class="form-control" name="empbon"/>
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