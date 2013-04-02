<%@ page language="java" session="true" contentType="text/html;charset=UTF-8"%>
<%@include file="common/includes.jsp" %>
<html>
<head>
    <title>实施监护</title>
    <%@include file="common/staticRef.jsp" %>
    <script type="text/javascript" src="js/realTimeData.js"></script>
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
                        <h2>实施监护</h2>
                    </div>

                    <h2>心电波形</h2>
                    <div id="electrocardiogram" style="width:600px;height:300px;"></div>
                    <h2>血氧波形</h2>
                    <div id="bloodoxygendiogram" style="width:600px;height:300px;"></div>
                    <h2>体温</h2>
                    <div id="temperature">无数据</div>
                    <h2>心率</h2>
                    <div id="heartRate">无数据</div>
                    <h2>血氧</h2>
                    <div id="bloodOxygen">无数据</div>

                </div>
            </div><!--/span-->
        </div><!--/row-->
    </div>
    <%@include file="common/foot.jsp" %>
</div>
</body>
</html>