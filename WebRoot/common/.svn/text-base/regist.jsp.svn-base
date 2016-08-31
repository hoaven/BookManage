<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>注册</title>
<script>
	function check() {
		var reguName = /^[\u4e00-\u9fa5A-Za-z0-9]{3,10}$/;
		var reguPass = /^[0-9a-zA-Z]{3,20}$/;
		var uName = document.regForm.username.value;
		var uPass = document.regForm.password.value;
		var uPass1 = document.regForm.password1.value;
		var num = document.regForm.num.value;
		if (uName == "") {
			alert("用户名不能为空");
			return false;
		}

		if (uPass == "") {
			alert("密码不能为空");
			return false;
		}

		if(num == "") {
			alert("学号不能为空");
			return false;
		}
		if (!uName.match(reguName)) {
			alert("用户名只能输入中文、数字、字母，长度为3-10");
			return false;
		}

		if (!uPass.match(reguPass)) {
			alert("密码只能输入数字、字母，长度为3-20");
			return false;
		}

		if (uPass != uPass1) {
			alert("2次密码不一样");
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
	<a href="${pageContext.request.contextPath}/">返回首页</a>
	<h1 align="center">输入注册信息</h1>
	<div class="form_content">
		<form name="regForm" onSubmit="return check()" action="${pageContext.request.contextPath}/common/regist.do"
			method="post">
			<fieldset>
				<div class="form-row">
					<div class="field-label">请输入用户名：</div>
					<div class="field-widget">
						<input type="text" name="username" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">请输入密码：</div>
					<div class="field-widget">
						<input type="password" name="password" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">确认密码：</div>
					<div class="field-widget">
						<input type="password" name="password1" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">请输入学号：</div>
					<div class="field-widget">
						<input type="text" name="num" />
					</div>
				</div>


				<div class="form-row">
					<br /> <br />
					<p>
						<input type="submit"
							src="${pageContext.request.contextPath}/common/images/01.jpg" />
					</p>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>