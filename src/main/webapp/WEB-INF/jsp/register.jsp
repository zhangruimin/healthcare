<%@ page language="java" session="true"
	contentType="text/html;charset=UTF-8"%>
<%@include file="common/includes.jsp"%>
<html>
<head>
<title>注册</title>
<%@include file="common/staticRef.jsp"%>
</head>
<body>
	<div class="container-outer">
		<div class="navbar">
			<span class="logo logo-login"></span>
		</div>
		<div class="container-fluid user-info-form" id="register-form">
			<span id="register-form-bg"> </span> 
				<form id="register-left-bg" method="post" action="/healthcare/register">
					<dl>
						<dt>用户名：</dt>
						<dd>
							<input type="text" name="userName" style="width:175px" >
							<div class="register-note"><div class="register-hint">请输入字母数字或下划线</div></div>
						</dd>
						<dt>密码：</dt>
						<dd>
							<input type="password" name="password" style="width:175px">
							<div class="register-note"><div class="register-hint">请输入字母数字或下划线</div></div>
						</dd>
						<dt>确认密码：</dt>
						<dd>
							<input type="text" name="passwordConfirm" style="width:175px">
							<div class="register-note"><div class="register-hint">请再次输入密码</div></div>
						</dd>
						<dt>手机号：</dt>
						<dd>
							<input type="text" name="phoneNumber" style="width:175px">
							<div class="register-note"><div class="register-hint">请输入您的手机号</div></div>
						</dd>
						<dt>邮箱：</dt>
						<dd>
							<input type="text" name="email" style="width:175px">
							<div class="register-note"><div class="register-hint">请输入您的常用邮箱</div></div>
						</dd>
						<dt>年龄：</dt>
						<dd>
							<input type="text" name="age" style="width:175px">
							<div class="register-note"><div class="register-hint">请输入您的年龄</div></div>
						</dd>
						<dt>身高：</dt>
						<dd>
							<input type="text" name="height" style="width:175px">
							<div class="register-note"><div class="register-hint">请输入您的身高</div></div>
						</dd>
						<dt>体重：</dt>
						<dd>
							<input type="text" name="weight" style="width:175px">
							<div class="register-note"><div class="register-hint">请输入您的体重</div></div>
						</dd>
						<dt>性别：</dt>
						<dd class="gender">
							<span><input type="radio" name="gender" value="Male"
								checked="true">男</span><span><input type="radio"
								name="gender" value="Female">女</span>
						</dd>
						<dt>职业：</dt>
						<dd>
							<select name="career" style="width:175px">
								<option value="NonManuel">白领（非体力工作者）</option>
								<option value="Manuel">普通工作者（体力工作者）</option>
								<option value="HeavyManuel">运动员（重体力工作者）</option>
							</select>
						</dd>
					</dl>
					<input id="register" type="submit" value="立即注册">
				</form>
		</div>
		<%@include file="common/foot.jsp"%>
	</div>
</body>
</html>