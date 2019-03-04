<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
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
            background: #9d9d9d;
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
        <%--更改密码表单--%>
        <form class="form-horizontal" action="/updateAaPassServlet" method="post">
            <div class="form-group">
                <label class="col-sm-2 control-label">管理员:</label>
                <div class="col-sm-10">
                    <input type="text" width="300px" name="adname" class="form-control" placeholder="默认为admin">
                </div>
            </div>
            <div class="form-group">
                <label for="question" class="col-sm-2 control-label">问题:</label>
                <div class="col-sm-10">
                    <select name="question" id="question" class="form-control">
                        <option value="你最喜欢的数字是什么" selected>你最喜欢的数字是什么</option>
                        <option value="你的年龄是多少">你的年龄是多少?</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">答案:</label>
                <div class="col-sm-10">
                    <input type="password" width="300px" name="daan" class="form-control" placeholder="请输入你的答案">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-default" value="确定"/>
                </div>
            </div>
        </form>


    </div>
</div>
</form>
</body>
</html>
<%@include file="../footer.jsp" %>
