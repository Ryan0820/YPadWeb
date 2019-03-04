<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="test/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.js"></script>
</head>
<body>
<!--top头部-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- logo -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">YPad</a>
        </div>

        <!-- 订餐分类 -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <!-- 后台系统-->
            <!--菜系-->
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">菜系<span class="caret"></span></a>
                    <!--菜品-->
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/listFoodByPageBeanServlet">所有美食</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=豫菜">豫菜</a></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=湘菜">湘菜</a></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=粤菜">粤菜</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=欧美">欧美风格</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=日韩">日韩料理</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=东南亚">东南亚美味</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=汤粥">汤粥系列</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/foodListBysciServlet?foodsci=水饮">水果饮料</a></li>
                    </ul>
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/listOrderByLimitServlet">订单系统 <span class="sr-only">(current)</span></a>
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/listEmpServlet">员工管理 <span class="sr-only">(current)</span></a>
                </li>
                <li class="active">
                    <%--<a href="${pageContext.request.contextPath}/listReptServlet">仓库管理 <span class="sr-only">(current)</span></a>
                    --%><a href="${pageContext.request.contextPath}/listReptByPageBeanServlet">仓库管理 <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <%--<form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入菜名" >
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>--%>
            <ul class="nav navbar-nav navbar-right">
                <!--用户登录-->
                <li><a href="#">欢迎您,管理员!</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true" aria-expanded="false"
                    >账户<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="../adpage/uppass.jsp">账户</a></li>
                        <li><a href="../adpage/Adlogin.jsp">退出</a></li>
                        <!--<li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>-->
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--end-->


</body>
</html>
