<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@include file="common/includes.jsp" %>
<html>
<head>
    <title>基本信息</title>
    <%@include file="common/staticRef.jsp" %>
</head>
<body>
<div class="container-outer">
    <%@include file="common/navbar.jsp" %>
    <div class="container-fluid user-info-form">
        <div class="row-fluid">
            <%@include file="common/sidebar.jsp" %>

            <div class="span9">
                <div class="hero-unit">
                    <div id="header">
                        <h2>基本信息</h2>
                    </div>
                     <div class="header-bottom"></div>

                    <div id="content">
                        <form method="post" action="/healthcare/basicInfo">
                            <dl>
                                <dt>用户名：</dt>
                                <dd><input type="text" name="userName" value="${currentUser.userName}"></dd>
                                <dt>性别：</dt>
                                <dd class="gender"><span><input type="radio" name="gender" value="Male" checked="true">男</span><span><input type="radio" name="gender" value="Female">女</span></dd>
                                <dt>身高：</dt>
                                <dd><input type="text" name="height" value="${currentUser.height}"></dd>
                                <dt>体重：</dt>
                                <dd><input type="text" name="weight" value="${currentUser.weight}"></dd>
                                <dt>年龄：</dt>
                                <dd><input type="text" name="age" value="${currentUser.age}"></dd>
                                <dt>步长：</dt>
                                <dd><input type="text" name="stepLength" value="${currentUser.stepLength}">cm</dd>
                                <dt>职业：</dt>
                                <dd>
                                    <select name="career">
                                        <option value="NonManuel">白领（非体力工作者）</option>
                                        <option value="Manuel">普通工作者（体力工作者）</option>
                                        <option value="HeavyManuel">运动员（重体力工作者）</option>
                                    </select>
                                </dd>
                                <dt>手机号：</dt>
                                <dd><input type="text" name="phoneNumber" value="${currentUser.phoneNumber}"></dd>
                                <dt>邮箱：</dt>
                                <dd><input type="text" name="email" value="${currentUser.email}"></dd>
                            </dl>
                            <input id="register" type="submit" value="确定">
                        </form>
                    </div>
                </div>
                <!--/span-->
            </div>
            <!--/row-->
        </div>
    </div>
    <%@include file="common/foot.jsp" %>
</div>
</body>
</html>