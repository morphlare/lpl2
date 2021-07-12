<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2021/6/20
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <ul class="pagination" style="display: inline-block;">
        <li><a href="javascript:page_nav(document.forms[0],'${param.currentPageNo-1}','${param.totalPageCount}')">&laquo;</a></li>
        <%
            for (int i = 1; i < (Integer.parseInt(request.getParameter("totalPageCount")) + 1); i++) {
        %>
        <li><a href="javascript:page_nav(document.forms[0],'<%=i%>','${param.totalPageCount}')"><%=i%></a></li>
        <%
            }
        %>
        <li><a href="javascript:page_nav(document.forms[0],'${param.currentPageNo+1}','${param.totalPageCount}')">&raquo;</a></li>
    </ul>
</div>
</body>
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rollpage.js"></script>
</html>
