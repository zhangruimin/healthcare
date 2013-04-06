<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@include file="common/includes.jsp" %>
<html>
<head>
    <title>健康档案</title>
    <%@include file="common/staticRef.jsp" %>
    <script type="text/javascript" src="js/initTabs.js"></script>
</head>
<body>
<div class="container-outer">
    <%@include file="common/navbar.jsp" %>
    <div class="container-fluid">
        <div class="row-fluid">
            <%@include file="common/sidebar.jsp" %>

            <div class="span9 health-archive">
                <div class="hero-unit">
                    <div id="header">
                        <h2>健康档案</h2>
                    </div>

                    <div id="content">
                        <div align="center">
                            <div id="tabs">
                                <ul>
                                    <li><a href="#tabs-1">常规检查</a></li>
                                    <li><a href="#tabs-2">生活习惯</a></li>
                                    <li><a href="#tabs-3">住院病史</a></li>
                                </ul>
                                <div id="tabs-1">
                                    <table>
                                        <tr class="with-separator">
                                            <td>检查日期:</td>
                                            <td>2013-03-31</td>
                                        </tr>
                                        <tr>
                                            <td>身高:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>体重:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>BMI指数:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>腰围:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>臀围:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>体温:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>呼吸:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>心率:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>血型:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>药物过敏史:</td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="tabs-2">
                                    <table>
                                        <tr>
                                            <td>吸烟情况:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>饮酒情况:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>其它不良嗜好:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>运动情况:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>饮食情况:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>睡眠情况:</td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="tabs-3">
                                    <table>
                                        <tr>
                                            <td>现病史:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>既往史:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>个人史:</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>家庭史:</td>
                                            <td></td>
                                        </tr>
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