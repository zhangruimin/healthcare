<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@include file="common/includes.jsp" %>
<html>
<head>
    <title>设备管理</title>
    <%@include file="common/staticRef.jsp" %>
</head>
<body>
<div class="container-outer">
    <%@include file="common/navbar.jsp" %>
    <div class="container-fluid">
        <div class="row-fluid">
            <%@include file="common/sidebar.jsp" %>

            <div class="span9">
                <div class="hero-unit">
                    <div id="header">
                        <h2>设备管理</h2>
                    </div>

                    <div id="content">

                        <table id="table1" width="700" border="1" cellpadding="0"
                               cellspacing="0">
                            <tr>
                                <th width="40%">设备编号</th>
                                <th width="40%">设备类型</th>
                                <th width="20%">操作</th>
                            </tr>
                            <c:forEach var="device" items="${devices}">
                                <tr>
                                    <td>${device.deviceId}</td>
                                    <td>${device.deviceType}</td>
                                    <td><a href="/healthcare/users/deleteDevice?deviceId=${device.deviceId}">删除</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <form class="add_devices" method="post" action="/healthcare/users/devices">
                            <input type="text" name="deviceId">
                            <select name="deviceType">
                                <option value="Monitor">监控仪</option>
                            </select>
                            <input type="submit" value="添加">
                        </form>
                    </div>
                </div>
            </div>

            <hr>
        </div>
    </div>
    <%@include file="common/foot.jsp" %>
</div>
</body>
</html>