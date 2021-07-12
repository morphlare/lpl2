<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2021/6/19
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form action="http://localhost:8080/lpl2/player/pwdUpdate" class="form-horizontal" role="form" method="post" id="pwdForm">
    <br/>
    <c:if test="${not empty message}">
        <span class="label label-danger label-lg col-sm-offset-2">${message}</span><br/>
    </c:if>
    <br/>
    <div class="form-group">
        <label class="col-sm-2 control-label"> 旧&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：&nbsp;</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="oldPassword" id="oldPassword" placeholder="请输入旧密码">
        </div>
        <p class="text-primary lead" id="mg1">*</p>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label"> 新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：&nbsp;</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="请输入新密码">
        </div>
        <p class="text-primary lead" id="mg2">*</p>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label"> 确认新密码：</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="renewPassword" id="renewPassword" placeholder="请确认新密码">
        </div>
        <p class="text-primary lead" id="mg3">*</p>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-1">
            <button type="button" class="btn btn-primary btn-lg" id="save">确定</button>
        </div>
        <div class="col-sm-offset-2 col-sm-2">
            <button type="reset" class="btn btn-primary btn-lg">重置</button>
        </div>
    </div>
</form>
<%@include file="common/foot.jsp"%>
