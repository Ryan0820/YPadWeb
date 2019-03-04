<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="/homepage/loginheader.jsp" %>
<html>
<head>
    <title>YPad欢迎您的光临!</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <style>
        #bg {
            width: auto;
            height: 350px;
            background-image: url("img/ibg.jpg");
            width: auto;
            background-repeat: no-repeat;
        }
        #login{
            padding-top: 50px;
        }
    </style>
</head>
<body>
<div id="bg">
    <div id="login">
        <%@include file="homepage/login.jsp" %>
    </div>
</div>
<%--<div id="goadmin">

    <a href="adpage/AdIndex.jsp">后台管理</a>
</div>--%>

</body>
</html>
<%@include file="/footer.jsp" %>
