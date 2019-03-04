<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>员工登录</title>
    <style>
        #bg {
            width: auto;
            height: 350px;
            background: #397DC4;

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
<%--Adlogin--%>
<div id="bg">
    <div id="login">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/empLoginServlet" method="post">
            <div class="form-group">
                <label class="col-sm-2 control-label">工号:</label>
                <div class="col-sm-10">
                    <input type="text" width="300px" name="empid" class="form-control" id="inputuser" placeholder="请输入工号">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-10">
                    <input type="text" width="300px" name="empname" class="form-control" id="inputPassword" placeholder="请输入姓名">
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
                </div>
            </div>
            <!-- 出错显示的信息框 -->
            <div class="alert alert-warning alert-dismissible" role="alert"
                 style="height: 30px;width: 200px; margin-top: 5px;padding-top: 5px">
                <button type="button" class="close" data-dismiss="alert">
                    <span>&times;</span>
                </button>
                <strong>${login_msg}</strong>
            </div>
        </form>
    </div>
</div>
</body>
</html>