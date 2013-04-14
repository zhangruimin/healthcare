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
                            <div id="HR-real-time">
                                <div id="HR-real-time-label">HR</div>
                                <div id="HR-real-time-data" class="real-time-data">---</div>
                            </div>

                            <div id="NIBP-real-time">
                                <div id="NIBP-real-time-label">NIBP</div>
                                <div id="NIBP-real-time-data" class="real-time-data">__/__/__</div>
                            </div>

                            <div id="SpO2-related-data" class="related-data-container">
                                <div id="SpO2-real-time">
                                    <div id="SpO2-label">SpO2%</div>
                                    <div id="bloodOxygen" class="real-time-data">___</div>
                                </div>

                                <div id="PR-real-time">
                                    <div id="PR-label">PR(:bmp)</div>
                                    <div id="PRData" class="real-time-data">___</div>
                                </div>
                            </div>
                            <div class="related-data-container">
                                <div id="RESP-real-time">
                                    <div id="RESP-label">RESP</div>
                                    <div id="RESP-value" class="real-time-data">___</div>
                                </div>
                                <div id="TEMP-real-time">
                                    <div id="TEMP-label">TEMP</div>
                                    <div id="temperature" class="real-time-data">___</div>
                                </div>
                            </div>

                            <div id="GLU-real-time" class="related-data-container">
                                <div id="GLU-real-time-label">GLU</div>
                                <div id="GLU-real-time-data" class="real-time-data">__._</div>
                            </div>
                        </div>

                        <div id="ECG-wave" class="wave">
                            <div id="ECG-wave-label" class="wave-label">ECG</div>
                            <div id="electrocardiogram"></div>
                            <div class="horizontal-bar"></div>
                            <div class="right-border"></div>
                        </div>

                        <div id="SpO2-wave" class="wave">
                            <div id="SpO2-wave-label" class="wave-label">SpO2</div>
                            <div id="bloodoxygendiogram"></div>
                            <div class="horizontal-bar"></div>
                            <div class="right-border"></div>
                        </div>

                        <div id="RESP-wave" class="wave">
                            <div id="RESP-wave-label" class="wave-label">RESP</div>
                            <div id="RESPdiogram"></div>
                            <div class="right-border"></div>
                        </div>
                        <div class="vertical-bar"></div>
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