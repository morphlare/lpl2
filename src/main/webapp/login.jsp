<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <meta charset="utf-8">
    <title>LPL选手管理系统-登录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body background="img/login.jpg">
<br/><br/><br/><br/><br/><br/>
<h1><span class="glyphicon glyphicon-fire"></span> LPL选手管理系统</h1><hr/><br/><br/>
<form action="http://localhost:8080/lpl2/player/login" class="form-horizontal" role="form" method="get">
    <div class="form-group">
        <label class="col-sm-2 control-label"><i class="fa fa-user-circle-o" aria-hidden="true"></i>&nbsp;用户名：</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" name="userName" placeholder="请输入用户名">
        </div>
    </div><br/>
    <div class="form-group">
        <label class="col-sm-2 control-label"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
        <div class="col-sm-9">
            <input type="password" class="form-control" name="password" placeholder="请输入密码">
        </div>
    </div>
    <c:if test="${not empty error}">
        <span class="label label-danger label-lg col-sm-offset-2">${error}</span><br/>
    </c:if>
    <br/>
    <div class="form-group">
        <div class="col-sm-offset-3 col-sm-2">
            <button type="submit" class="btn btn-warning btn-lg">确定</button>
        </div>
        <div class="col-sm-offset-3 col-sm-2">
            <button type="reset" class="btn btn-warning btn-lg">重置</button>
        </div>
    </div>
</form>
</body>
</html>
