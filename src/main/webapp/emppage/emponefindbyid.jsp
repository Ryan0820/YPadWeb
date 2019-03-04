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
        function delEmpId(id) {
            //用户安全提示
            if (confirm("您确定删除此条记录吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delEmpServlet?empid=" + id;
            }
        }
        function delEmpDay(empday , empid) {
            //用户安全提示
            if (confirm("您确定 ${emp.empname} 今天没打卡吗？")) {
                //访问路径
                <%--${pageContext.request.contextPath}/daySubtractServlet?empday=${emp.empday}&empid=${emp.empid}--%>
                location.href = "${pageContext.request.contextPath}/daySubtractServlet?empday=" + empday+"&empid=" + empid;
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
    <h3 style="text-align: center">员工信息表</h3>
    <div id="selecttop">
        <form class="form-inline" action="${pageContext.request.contextPath}/findOneEmpServlet">
            <%--<div class="form-group">
                <label for="exampleInputName2">名字:</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>--%>
            <div class="form-group">
                <label for="exampleInputEmail2">请输入工号查询:</label>
                <input type="text" value="${emp.empid}" name="empid" class="form-control" id="exampleInputEmail2">
            </div>
            <input type="submit" class="btn btn-default" value="查询"></input>
        </form>
    </div>
    <div id="addUsers">
        <a class="btn btn-primary" href="../emppage/empadd.jsp">添加员工</a>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>身份证</th>
            <th>联系方式</th>
            <th>部门</th>
            <th>出勤天数</th>
            <th>员工工资(元)</th>
            <th>员工奖金(元)</th>
            <th>员工实发工资(元)</th>

            <th>操作</th>
        </tr>
        <tr>
            <td>${emp.empid}</td>
            <td width="100px">${emp.empname}</td>
            <td>${emp.empgender}</td>
            <td>${emp.empsfz}</td>
            <td>${emp.empphone}</td>
            <td>${emp.empdept}</td>
            <td>${emp.empday}&nbsp;
                <a class="btn btn-default btn-sm" href="javascript:delEmpDay(${emp.empday}, ${emp.empid});">-</a>
            </td>
            <td>${emp.empsal}</td>
            <td>${emp.empbon}</td>
            <td>${(emp.empsal + emp.empbon) + (emp.empday * 50)}</td>
            <td>
                <a class="btn btn-default btn-sm"
                   href="${pageContext.request.contextPath}/updateFindIdServlet?empid=${emp.empid}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="javascript:delEmpId(${emp.empid});">删除</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
<%@include file="/footer.jsp" %>