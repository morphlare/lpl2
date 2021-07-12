<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2021/6/20
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="common/head.jsp"%>

<table class="table-hover table-striped table-condensed" cellpadding="0" cellspacing="0" width=80%" style="margin-left: 10%; text-align: center">
    <tr>
        <th style="text-align: center">战队ID</th>
        <th style="text-align: center">战队名称</th>
        <th style="text-align: center">s赛冠军</th>
        <th style="text-align: center">地址</th>
    </tr>
    <c:forEach var="rank" items="${rankList}" varStatus="status">
        <tr>
            <td>
                <span>${rank.rankId}</span>
            </td>
            <td>
                <span>${rank.rankName}</span>
            </td>
            <td>
                <c:if test="${rank.isChampion == true}">
                    <i class="fa fa-trophy" aria-hidden="true"></i>
                </c:if>
                <c:if test="${rank.isChampion == false}">
                    <span class="glyphicon glyphicon-remove"></span>
                </c:if>
            </td>
            <td>
                <span>${rank.address}</span>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/foot.jsp"%>
