<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@include file="common/includes.jsp" %>
<html>
<head>
    <title>健康查询</title>
    <%@include file="common/staticRef.jsp" %>
    <script type="text/javascript" src="js/initTabs.js"></script>
</head>
<body>
<div class="container-outer health-query">
    <%@include file="common/navbar.jsp" %>
    <div class="container-fluid">
        <div class="row-fluid">
            <%@include file="common/sidebar.jsp" %>

            <div class="span9">
                <div class="hero-unit">
                    <div id="header">
                        <h2>健康查询</h2>
                    </div>
            <div class="header-bottom"></div>

                    <div id="content">
                        <div class="time-range">
                            <a href="/healthcare/healthQuery">上一天</a>
                            <a href="/healthcare/healthQuery?timeRange=LAST_WEEK">上一周</a>
                            <a href="/healthcare/healthQuery?timeRange=LAST_MONTH">上一月</a>
                        </div>
                        <div class="clear"></div>
                        <div align="center">
                            <div id="tabs">
                                <ul>
                                    <li><a href="#tabs-1">体温</a></li>
                                    <li><a href="#tabs-2">心率</a></li>
                                    <li><a href="#tabs-3">血氧</a></li>
                                     <li><a href="#tabs-4">呼吸率</a></li>
                                    <li><a href="#tabs-5">脉率</a></li>
                                    <li><a href="#tabs-6">血压</a></li>
                                     <li><a href="#tabs-7">血糖</a></li>
                                </ul>
                                
                                <div id="tabs-1">
                                    <table class="query-result" id="table1" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${temperatureRecords}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF">${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                                <div id="tabs-2">
                                    <table class="query-result" id="table2" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${HRRecords}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF">${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                
                                <div id="tabs-3">
                                    <table class="query-result" id="table3" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${SPO2Records}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF">${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                
                                 <div id="tabs-4">
                                    <table class="query-result" id="table4" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${RESPRecords}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF">${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                
                                 <div id="tabs-5">
                                    <table class="query-result" id="table5" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${PRRecords}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF">${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                
                                 <div id="tabs-6">
                                    <table class="query-result" id="table6" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${NIBPRecords}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF">${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                
                                 <div id="tabs-7">
                                    <table class="query-result" id="table7" width="700" border="0" cellpadding="0"
                                           cellspacing="0">
                                        <tr>
                                            <th width="20%">硬件编号</th>
                                            <th width="40%">监测时间</th>
                                            <th width="40%">数值</th>
                                        </tr>
                                        <c:forEach var="record" items="${BSRecords}">
                                            <tr>
                                                <td style="color:#0088FF">${record.deviceId}</td>
                                                <td style="color:#0088FF">${record.timestamp}</td>
                                                <td style="color:#0088FF"s>${record.data}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                
                            </div>

                        </div>
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