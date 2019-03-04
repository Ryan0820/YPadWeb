<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="test/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <title>后台系统</title>
    <style>
        #bg {
            width: auto;
            height: 400px;
            /*background: #397DC4;*/
            background-image: url("../img/ibg.jpg");
            width: auto;
            background-repeat: no-repeat;
        }

        #login {
            padding-top: 50px;
        }

        .col-sm-10 {
            width: 300px;
        }

    </style>
    <script type="text/javascript">
        //切换验证码
        function refreshCode() {
            //1.获取验证码图片对象
            var vcode = document.getElementById("vcode");

            //2.设置其src属性，加时间戳
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }
    </script>
</head>
<body>

<!--top头部-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">

            <a class="navbar-brand" href="Adlogin.jsp">YPad</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">亲爱的管理员欢迎您的光临!
                        <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="bg">
<div id="login">
    <%--登录表单--%>
<form class="form-horizontal" action="/AdminServlet" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label">管理员:</label>
        <div class="col-sm-10">
            <input type="text" width="300px" name="adname" class="form-control" placeholder="默认为admin">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">密码:</label>
        <div class="col-sm-10">
            <input type="password" width="300px" name="adpass" class="form-control" placeholder="密码默认为root">
        </div>
    </div>

    <div class="form-group" >
        <label for="vcode" class="col-sm-2 control-label">验证码:</label>
        <div class="col-sm-10">
            <input type="text" width="300px" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码"/>
        </div>
        <div >
            <a href="javascript:refreshCode();">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>
    </div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" class="btn btn-default" value="登录"/>
        <a style="color: #333333" href="../adpage/uppass.jsp">忘记密码?</a>

        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" role="alert"
             style="height: 30px; margin-top: 5px;padding-top: 5px">
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span>
            </button>
            <strong>${login_msg}</strong>
        </div>
    </div>
</div>
</form>


</div>
</div>
</form>
</body>
</html>
<%@include file="../footer.jsp" %>
