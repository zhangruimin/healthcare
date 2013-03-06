<%@ page language="java" session="true" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>健康查询</title>
    <%@include file="common/staticRef.jsp" %>
    <script type="text/javascript" src="js/healthQuery.js"></script>
</head>
<body>
<%@include file="common/navbar.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@include file="common/sidebar.jsp" %>

        <div class="span9">
            <div class="hero-unit">
                <div id="header">
                    <h2>健康查询</h2>
                </div>

                <div id="content">
                    <button>上一天</button>
                    <button>上一周</button>
                    <button>上一月</button>

                    <div align="center">
                        <div id="tabs">
                            <ul>
                                <li><a href="#tabs-1">体温</a></li>
                                <li><a href="#tabs-2">血压</a></li>
                                <li><a href="#tabs-3">血氧</a></li>
                            </ul>
                            <div id="tabs-1">

                                <div class="demo-container">
                                    <div id="placeholder1" class="demo-placeholder"></div>
                                </div>

                                <p>
                                    <button class="fetchSeries">显示趋势图</button>
                                    [ <a href="body-temperature.json">see data</a> ] <span></span>
                                </p>

                                <table id="table1" width="700" border="1" cellpadding="0"
                                       cellspacing="0">
                                    <tr>
                                        <td width="20%">硬件编号</td>
                                        <td width="40%">监测时间</td>
                                        <td width="40%">数值</td>
                                    </tr>
                                    <tr>
                                        <td>001</td>
                                        <td>2012-12-26 09:00</td>
                                        <td>37</td>
                                    </tr>
                                    <tr>
                                        <td>001</td>
                                        <td>2012-12-26 09:05</td>
                                        <td>37</td>
                                    </tr>
                                    <tr>
                                        <td>001</td>
                                        <td>2012-12-26 09:10</td>
                                        <td>37</td>
                                    </tr>
                                    <tr>
                                        <td>001</td>
                                        <td>2012-12-26 09:15</td>
                                        <td>37</td>
                                    </tr>
                                </table>
                            </div>
                            <div id="tabs-2">

                                <div class="demo-container">
                                    <div id="placeholder2" class="demo-placeholder"></div>
                                </div>

                                <p>
                                    <button class="fetchSeries">显示趋势图</button>
                                    [ <a href="blood-pressure.json">see data</a> ] <span></span>
                                </p>

                                <table id="table2" width="700" border="1" cellpadding="0"
                                       cellspacing="0">
                                    <tr>
                                        <td width="20%">硬件编号</td>
                                        <td width="40%">监测时间</td>
                                        <td width="40%">高/均/低</td>
                                    </tr>
                                    <tr>
                                        <td>002</td>
                                        <td>2012-12-26 09:00</td>
                                        <td>120/96/78</td>
                                    </tr>
                                    <tr>
                                        <td>002</td>
                                        <td>2012-12-26 09:05</td>
                                        <td>120/96/78</td>
                                    </tr>
                                    <tr>
                                        <td>002</td>
                                        <td>2012-12-26 09:10</td>
                                        <td>120/96/78</td>
                                    </tr>
                                    <tr>
                                        <td>002</td>
                                        <td>2012-12-26 09:15</td>
                                        <td>120/96/78</td>
                                    </tr>
                                </table>
                            </div>
                            <div id="tabs-3">

                                <div class="demo-container">
                                    <div id="placeholder3" class="demo-placeholder"></div>
                                </div>

                                <p>
                                    <button class="fetchSeries">显示趋势图</button>
                                    [ <a href="blood-oxygen.json">see data</a> ] <span></span>
                                </p>

                                <table id="table3" width="700" border="1" cellpadding="0"
                                       cellspacing="0">
                                    <tr>
                                        <td width="20%">硬件编号</td>
                                        <td width="40%">监测时间</td>
                                        <td width="40%">数值</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:00</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:05</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:10</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:15</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:00</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:05</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:10</td>
                                        <td>98</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>2012-12-26 09:15</td>
                                        <td>98</td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <!--			<p>
                            <button class="fetchSeries">Second dataset</button>
                            [ <a href="blood-pressure.json">see data</a> ] <span></span>
                            </p>

                            <p>
                            <button class="fetchSeries">Third dataset</button>
                            [ <a href="body-temperature.json">see data</a> ] <span></span>
                            </p> -->
                        <p>
                            <button class="dataUpdate">Poll for data</button>
                        </p>

                    </div>
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