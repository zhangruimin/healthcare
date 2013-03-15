<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>用户登录</title>
    <%@include file="common/staticRef.jsp" %>
</head>
<body>
<div class="container-fluid">
    <form method="post" action="/healthcare/login">
        <dl>
        <dt>用户名：</dt><dd><input type="text" name="userName"></dd>
        <dt>密码：</dt><dd><input type="password" name="password"></dd>
        <input type="submit">
        </dl>
    </form>

    <%@include file="common/foot.jsp" %>

</div>

</body>
</html>