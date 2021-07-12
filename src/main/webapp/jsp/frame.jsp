<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2021/6/16
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="common/head.jsp"%>
<br>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/frame.css">
<div class="media media-lg" style="margin-left: 260px" id="media">
    <div class="media-left media-middle">
        <img src="${user_session.getPic()}" class="media-object" style="width:110px">
    </div>
    <div class="media-body" id="media-body">
        <br/>
        <h3 class="media-heading">${user_session.getPlayerName()} 选手</h3>
        <p>
            选手ID：${user_session.getPlayerName()}<br/>
            选手位置：${user_session.getRole()}<br/>
            战队名称：${user_session.getRankName()}<br/>
            年龄：${user_session.getAge()}<br/>
            性别：${user_session.getSex()}<br/>
        </p>
        <br/>
    </div>
</div>
<%@include file="common/foot.jsp"%>
