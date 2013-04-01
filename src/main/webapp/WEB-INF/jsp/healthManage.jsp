<%@ page language="java" session="true"
	contentType="text/html;charset=UTF-8"%>
<%@include file="common/includes.jsp"%>
<html>
<head>
<title>健康管理</title>
 <%@include file="common/staticRef.jsp" %>
<link href="/healthcare/css/bootstrap/bootstrap-new-examples.css"
	rel="stylesheet" />
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="../../excanvas.min.js"></script><![endif]-->
<script type="text/javascript" src="js/lib/jquery-c.js"></script>
<script type="text/javascript" src="js/lib/jquery-flot-c.js"></script>
<script type="text/javascript" src="js/lib/jquery.flot.time.js"></script>
<script type="text/javascript" src="js/lib/jquery-ui.js"></script>
<script type="text/javascript" src="js/healthManage.js"></script>

</head>
<body>
	<div class="container-outer">
		<%@include file="common/navbar.jsp"%>
		<div class="container-fluid">
			<div class="row-fluid">
				<%@include file="common/sidebar.jsp"%>

				<div class="span9">
					<div class="hero-unit">
						<div id="header">
							<h2>健康管理</h2>
						</div>

						<div id="content">
							<a id="lastday">上一天</a> 
							<a id="lastweek">上一周</a> 
							<a id="lastmonth">上一月</a>

							<div class="center">
								<div id="tabs">
									<ul>
										<li><a href="#tabs-1">体温</a></li>
										<li><a href="#tabs-2">心率</a></li>
										<li><a href="#tabs-3">血氧</a></li>
									</ul>
									<div id="tabs-1">
										<div class="demo-container">
											<div id="placeholder1" class="demo-placeholder"></div>
										</div>
									</div>

									<div id="tabs-2">
										<div class="demo-container">
											<div id="placeholder2" class="demo-placeholder"></div>
										</div>
									</div>
									<div id="tabs-3">
										<div class="demo-container">
											<div id="placeholder3" class="demo-placeholder"></div>
										</div>
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
		<%@include file="common/foot.jsp"%>
	</div>
</body>
</html>