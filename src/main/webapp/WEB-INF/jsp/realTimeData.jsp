<%@ page language="java" session="true" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Main frame</title>
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/lib/jquery.js"></script>
    <script type="text/javascript" src="js/lib/jquery.flot.js"></script>
    <script type="text/javascript" src="js/lib/excanvas.js"></script>
    <script type="text/javascript" src="js/realTimeData.js"></script>
</head>
<body>
<%@include file="common/navbar.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@include file="common/sidebar.jsp" %>
        <div class="span9">
            <div class="hero-unit">
                <h2>心电波形</h2>
                <div id="electrocardiogram" style="width:600px;height:300px;"></div>
                <h2>血氧波形</h2>
                <div id="bloodoxygendiogram" style="width:600px;height:300px;"></div>
            </div>
        </div><!--/span-->
    </div><!--/row-->

    <hr>

    <footer>
        <p>&copy; Company 2013</p>
    </footer>

</div>

</body>
</html>