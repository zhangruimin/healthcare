<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>注册</title>
    <%@include file="common/staticRef.jsp" %>
</head>
<body>
<div class="container-outer">
    <div class="navbar navbar-inverse navbar-fixed-top">
    </div>
    <div class="container-fluid">
        <form method="post" action="/healthcare/register">
            <dl>
                <dt>用户名：</dt>
                <dd><input type="text" name="userName"></dd>
                <dt>密码：</dt>
                <dd><input type="password" name="password"></dd>
                <dt>确认密码：</dt>
                <dd><input type="password" name="passwordConfirm"></dd>
                <input type="submit" value="立即注册">
            </dl>
        </form>
    </div>
    <%@include file="common/foot.jsp" %>
</div>
</body>
</html>