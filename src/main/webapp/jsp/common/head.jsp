<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2021/2/19
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/head.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css">
    <script src="${pageContext.request.contextPath}/js/pwd_modify.js" charset="UTF-8"></script>
    <title>LPL选手管理系统首页</title>
</head>
<body>
<div id="d1">
    <span id="s0">
        <span id="s1"><span class="glyphicon glyphicon-fire"></span></span>
        <span id="s2">LPL</span>
        <span id="s3">选手管理系统</span>
    </span>
    <span id="s4">Welcome to League of Legends Pro League</span>
</div>
<nav class="navbar navbar-inverse" role="navigation" id="n1">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-fire"></span> LPL选手管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/jsp/frame.jsp"><i class="fa fa-home" aria-hidden="true"></i> 我的空间</a></li>
                <li><a href="${pageContext.request.contextPath}/player/logout"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/pwd_update.jsp"><i class="fa fa-lock" aria-hidden="true"></i> 修改密码</a></li>
                <li><a href="${pageContext.request.contextPath}/player/query"><i class="fa fa-cog fa-spin" aria-hidden="true"></i></span> 选手管理</a></li>
                <li><a href="${pageContext.request.contextPath}/rank/list"><i class="fa fa-flag-checkered" aria-hidden="true"></i> 战队列表</a></li>
            </ul>
        </div>
    </div>
</nav>

