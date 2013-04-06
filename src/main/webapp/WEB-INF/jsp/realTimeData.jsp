<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
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
                    <div id="real-time-container">
                        <div id="digit-real-time-data">
                            <div id="SpO2-real-time">
                                <div id="SpO2-label">SpO2%</div>
                                <div id="bloodOxygen">无数据</div>
                            </div>
                            <div id="RPbpm-real-time">
                                <div id="RPbpm-label">RPbpm</div>
                                <div id="heartRate">无数据</div>
                            </div>
                            <div id="RESP-real-time">
                                <div id="RESP-label">RESP</div>
                                <div id="RESP-value">无数据</div>
                            </div>
                            <div id="TEMP-real-time">
                                <div id="TEMP-label">TEMP</div>
                                <div id="temperature">无数据</div>
                            </div>
                        </div>

                        <div id="ECG-wave">
                            <div id="ECG-wave-label">ECG</div>
                            <div id="electrocardiogram"></div>
                        </div>

                        <div id="SpO2-wave">
                            <div id="SpO2-wave-label">SpO2</div>
                            <div id="bloodoxygendiogram"></div>
                        </div>
                    </div>

                </div>
            </div>
            <!--/span-->
        </div>
        <!--/row-->
    </div>
    <%@include file="common/foot.jsp" %>
</div>
</body>
</html>