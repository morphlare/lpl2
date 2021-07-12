<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2021/6/19
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/head.jsp"%>

<form id="f1" class="form-inline" role="form" method="get" action="${pageContext.request.contextPath }/player/query">
    <div class="form-group input-group col-sm-2 col-sm-offset-1">
        <span class="input-group-addon"><span class="glyphicon glyphicon-headphones"></span> 选手ID</span>
        <input type="text" class="form-control" id="playerName" placeholder="请输入选手ID" value="${queryName}" name="queryName">
    </div>
    <div class="form-group col-sm-offset-5">
        <label for="rankName"><span class="glyphicon glyphicon-flag"></span> 战队名称 </label>
        <select class="form-control" name="queryPlayerRank" id="rankName">
            <c:if test="${rankList != null}">
                <option value="0">--请选择--</option>
                <c:forEach var="rank" items="${rankList}">
                    <option <c:if test="${rank.rankId == queryPlayerRank}">selected="selected"</c:if>
                            value="${rank.rankId}">${rank.rankName}</option>
                </c:forEach>
            </c:if>
        </select>
    </div>&nbsp;
    <input type="hidden" name="pageIndex" value="1"/>
    <button type="submit" class="btn btn-primary form-control"><i class="fa fa-search"></i> 查询</button>&nbsp;&nbsp;
<c:choose>
    <c:when test="${user_session.getIdentity()==1}">
        <button type="button" class="btn btn-info form-control" data-toggle="modal" data-target="#insertPlayer${playerCount+1}"><i class="fa fa-user-plus" aria-hidden="true"></i> 添加选手</button>
    </c:when>
    <c:otherwise>
        <button type="button" class="btn btn-info form-control"><i class="fa fa-user-plus" aria-hidden="true"></i> 添加选手</button>
    </c:otherwise>
</c:choose>
</form>
<div class="modal fade" id="insertPlayer${playerCount+1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="insertPlayerLabel">添加选手</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath }/player/insert/${playerCount+1}" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">游戏ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="playerName"
                                   placeholder="请输入选手的游戏ID">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">战队名称</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="rankName">
                                <option>RNG</option>
                                <option>IG</option>
                                <option>JDG</option>
                                <option>TES</option>
                                <option>FPX</option>
                                <option>WE</option>
                                <option>EDG</option>
                                <option>RA</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">游戏位置</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="role">
                                <option>TOP</option>
                                <option>JUG</option>
                                <option>MID</option>
                                <option>ADC</option>
                                <option>SUP</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="age"
                                   placeholder="请输入选手的年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="sex">
                                <option>male</option>
                                <option>female</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password"
                                   placeholder="请输入选手的密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">头像</label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="pic" id="inputfile">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交更改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<table class="table-hover table-striped table-condensed" cellpadding="0" cellspacing="0" width=86%" style="margin-left:7%; text-align: center">
    <tr class="info">
        <th style="text-align: center; width: 12%">选手编号</th>
        <th style="text-align: center; width: 14%">选手ID</th>
        <th style="text-align: center; width: 12%">年龄</th>
        <th style="text-align: center; width: 12%">战队名称</th>
        <th style="text-align: center; width: 10%">性别</th>
        <th style="text-align: center; width: 14%">游戏位置</th>
        <th style="text-align: center; width: 12%">管理员权限</th>
        <th style="text-align: center; width: 14%">操作</th>
    </tr>
    <c:forEach var="player" items="${playerList}" varStatus="status">
        <tr>
            <td>
                <span>${player.playerId}</span>
            </td>
            <td>
                <span>${player.playerName}</span>
            </td>
            <td>
                <span>${player.age}</span>
            </td>
            <td>
                <span>${player.rankName}</span>
            </td>
            <td>
                <span>${player.sex}</span>
            </td>
            <td>
                <span>${player.role}</span>
            </td>
            <c:if test="${player.identity == 1}">
                <td><span>有</span></td>
            </c:if>
            <c:if test="${player.identity == 2}">
                <td><span>无</span></td>
            </c:if>
            <td>
                <%--实现显示选手信息功能--%>
                <c:choose>
                    <c:when test="${user_session.getIdentity()==1}">
                        <span><a href="javascript:;" data-toggle="modal" data-target="#displayPlayer${player.playerId}" playerId=${player.playerId} playerName=${player.playerName}><i class="fa fa-address-card"></i></a></span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="modal fade" id="displayPlayer${player.playerId}" tabindex="-1" role="dialog" aria-labelledby="displayPlayerLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="displayPlayerLabel">${player.playerName} 选手信息</h4>
                                    </div>
                                    <div class="modal-body">选手编号：${player.playerId}<br/>选手位置：${player.role}<br/>战队：${player.rankName}<br/>年龄：${player.age}<br/>性别：${player.sex}</div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <span><a href="javascript:;"><i class="fa fa-address-card"></i></a></span>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:otherwise>
                </c:choose>
                <%--实现编辑选手信息功能--%>
                <c:choose>
                    <c:when test="${user_session.getIdentity()==1}">
                        <span><a href="javascript:;" data-toggle="modal" data-target="#editPlayer${player.playerId}" playerId=${player.playerId} playerName=${player.playerName}><span class="glyphicon glyphicon-pencil"></span></a></span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="modal fade" id="editPlayer${player.playerId}" tabindex="-1" role="dialog" aria-labelledby="editPlayerLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="editPlayerLabel">${player.playerName} 修改选手信息</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form class="form-horizontal" role="form" method="get" action="${pageContext.request.contextPath }/player/edit/${player.playerId}">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">游戏ID</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="playerName"
                                                           placeholder="请输入新的游戏ID">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">战队名称</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control"  name="rankName"
                                                           placeholder="请输入转入战队名称">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">游戏位置</label>
                                                <div class="col-sm-10">
                                                    <select class="form-control" name="role">
                                                        <option>TOP</option>
                                                        <option>JUG</option>
                                                        <option>MID</option>
                                                        <option>ADC</option>
                                                        <option>SUP</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="submit" class="btn btn-primary">提交更改</button>
                                            </div>
                                        </form>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>
                    </c:when>
                    <c:otherwise>
                        <span><a href="javascript:;"><span class="glyphicon glyphicon-pencil"></span></a></span>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:otherwise>
                </c:choose>
                <%--实现删除选手数据功能--%>
                <c:choose>
                    <c:when test="${user_session.getIdentity()==1}">
                        <span><a href="javascript:;" data-toggle="modal" data-target="#removePlayer${player.playerId}" playerId=${player.playerId} playerName=${player.playerName}><span class="glyphicon glyphicon-remove"></span></a></span>
                        <div class="modal fade" id="removePlayer${player.playerId}" tabindex="-1" role="dialog" aria-labelledby="removePlayerLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="removePlayer">${player.playerName} 删除选手信息</h4>
                                    </div>
                                    <div class="modal-body">
                                        是否确定删除${player.playerName}选手信息？
                                        <form role="form" method="get" action="${pageContext.request.contextPath }/player/delete/${player.playerId}">
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                <button type="submit" class="btn btn-primary">确定</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <span><a href="javascript:;"><span class="glyphicon glyphicon-remove"></span></a></span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${playerCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
</c:import>
<%@include file="common/foot.jsp"%>
