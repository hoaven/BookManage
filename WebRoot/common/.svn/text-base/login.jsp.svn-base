<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>用户登录</title>
<script>
	function check() {
		if (document.loginForm.username.value == "") {
			alert("用户名不能为空");
			return false;
		}
		if (document.loginForm.password.value == "") {
			alert("密码不能为空");
			return false;
		}
	}
</script>

<style type="text/css">
body {
	background-color: darkslategray;
	padding: 0px;
	font-size: 12px;
	font-family: Arial, Helvetica, sans-serif;
}

h1 {
	font-family: 华文行楷;
	font-size: 45px;
	color: palegreen;
}

.form_content {
	width: 575px;
	margin: 30px auto;
	padding: 10px;
	background:
		url(${pageContext.request.contextPath}/common/images/center_bg3.gif)
		repeat top left;
}

.form-row {
	float: left;
	padding: 5px 5px 5px 5px;
}

.field-label {
	width: 150px;
	float: left;
	line-height: 25px;
	font-family: 楷体;
	font-size: 18px;
	color: #000000;
}

.field-widget {
	float: left;
}

a:link {
	color: khaki;
	text-decoration: none;
	font-family: 楷体;
	font-size: 18px;
}

a:hover {
	color: red;
}

a:visited {
	color: khaki;
}
</style>
</head>
<body>
${message}
	<a href="${pageContext.request.contextPath}">返回首页</a>
	<h1 align="center">欢迎登录图书管理系统</h1>
	<div class="form_content">
		<form action="${pageContext.request.contextPath}/common/login.do" onsubmit="return check()" name="loginForm" method="post">
			<fieldset>
				<div class="form-row">
					<div class="field-label">用户名：</div>
					<div class="field-widget">
						<input type="text" name="username" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">密码：</div>
					<div class="field-widget">
						<input type="password" name="password" />
					</div>
				</div>

				<div class="form-row">
					<br />
					<br />
					<p>
						<input type="submit"
							src="${pageContext.request.contextPath}/common/images/login.gif" />
					</p>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>