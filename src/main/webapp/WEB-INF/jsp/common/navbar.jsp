<%@ page language="java" session="true" contentType="text/html;charset=UTF-8"%>
<c:set var="currentUser" value='<%=request.getSession().getAttribute("currentUser")%>'/>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">康健中心</a>
            <div class="nav-collapse collapse">
                <p class="navbar-text pull-right">
                    当前用户： <a href="#" class="navbar-link">${currentUser.userName}</a>
                    <a href="/healthcare/logout" class="navbar-link">退出</a>
                </p>
                <ul class="nav">
                    <li class="active"><a href="#">首页</a></li>
                    <li><a href="#about">关于</a></li>
                    <li><a href="/healthcare/users/devices?userId=1">设备管理</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>