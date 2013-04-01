<%@ page language="java" session="true" contentType="text/html;charset=UTF-8" %>
<%@include file="common/includes.jsp" %>
<html>
<head>
    <title>健康档案</title>
    <%@include file="common/staticRef.jsp" %>
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
                        <h2>健康档案</h2>
                    </div>

                    <div id="content">
                       <div>
                           <h3>常规检查</h3>
                           <table>
                               <tr>
                                   <td span="3"><b>检查日期:</b>2013-03-31</td>
                               </tr>
                               <tr>
                                   <td>身高：无</td>
                                   <td>体重：无</td>
                                   <td>BMI指数：无</td>
                               </tr>
                               <tr>
                                   <td>腰围：无</td>
                                   <td>臀围：无</td>
                                   <td>体温：无</td>
                               </tr>
                               <tr>
                                   <td>呼吸：无</td>
                                   <td>心率：无</td>
                                   <td>血型：无</td>
                               </tr>
                               <tr>
                                   <td span="3">药物过敏史：无</td>
                               </tr>
                           </table>
                       </div>

                        <div>
                            <h3>生活习惯</h3>
                            <table>
                                <tr>
                                    <td>吸烟情况：</td>
                                    <td>是否吸烟：无&nbsp;&nbsp;&nbsp;&nbsp;吸烟量：无</td>
                                </tr>
                                <tr>
                                    <td>饮酒情况：</td>
                                    <td>是否饮酒：无&nbsp;&nbsp;&nbsp;&nbsp;饮酒量：无</td>
                                </tr>
                                <tr>
                                    <td>其它不良嗜好：</td>
                                    <td>无</td>
                                </tr>
                                <tr>
                                    <td>运动情况：</td>
                                    <td>有无运动习惯：无&nbsp;&nbsp;运动方式：无&nbsp;&nbsp;运动占频率：无&nbsp;&nbsp;运动时长：无</td>
                                </tr>
                                <tr>
                                    <td>饮食情况：</td>
                                    <td>饮食是否规律：无&nbsp;&nbsp;饮食偏好：无&nbsp;&nbsp;是否在外饮食：无</td>
                                </tr>
                                <tr>
                                    <td>睡眠情况：</td>
                                    <td>睡眠是否规律：无&nbsp;&nbsp;&nbsp;&nbsp;睡眠时长：无</td>
                                </tr>
                            </table>
                        </div>

                        <div>
                            <h3>住院病史</h3>
                            <table>
                                <tr>
                                    <td>现病史：</td>
                                    <td>无</td>
                                </tr>
                                <tr>
                                    <td>既往史：</td>
                                    <td>无</td>
                                </tr>
                                <tr>
                                    <td>个人史：</td>
                                    <td>无</td>
                                </tr>
                                <tr>
                                    <td>家庭史：</td>
                                    <td>无</td>
                                </tr>
                            </table>
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