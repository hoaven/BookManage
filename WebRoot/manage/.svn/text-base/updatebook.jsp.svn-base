<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>添加图书信息</title>
<script>
	function check() {
		var booknum = document.regForm.booknum.value;
		var bookname = document.regForm.bookname.value;
		var booktype = document.regForm.booktype.value;
		var bookauthor = document.regForm.bookauthor.value;
		var money = document.regForm.money.value;
		if (booknum == "") {
			alert("图书编号不能为空");
			return false;
		}

		if (bookname == "") {
			alert("图书名称不能为空");
			return false;
		}

		if (booktype == "") {
			alert("图书类型不能为空");
			return false;
		}

		if (bookauthor == "") {
			alert("图书作者不能为空");
			return false;
		}if (money == "") {
			alert("图书价格不能为空");
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
	<a href="${pageContext.request.contextPath}/manage/index.jsp">返回后台首页</a>
	<h1 align="center">输入图书信息</h1>
	<div class="form_content">
		<form name="regForm" onSubmit="return check()" action="${pageContext.request.contextPath}/manage/updatebook.do"
			method="post">
			<fieldset>
				<div class="form-row">
					<div class="field-label">图书编号：</div>
					<div class="field-widget">
						<input type="text" name="booknum" value="${updatebook.booknum}" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">图书名称：</div>
					<div class="field-widget">
						<input type="text" name="bookname" value="${updatebook.bookname}" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">图书类型：</div>
					<div class="field-widget">
						<input type="text" name="booktype" value="${updatebook.booktype}" />
					</div>
				</div>

				<div class="form-row">
					<div class="field-label">图书作者：</div>
					<div class="field-widget">
						<input type="text" name="bookauthor" value="${updatebook.bookauthor}" />
					</div>
				</div>
				
				<div class="form-row">
					<div class="field-label">图书价格：</div>
					<div class="field-widget">
						<input type="text" name="money" value="${updatebook.money}" />
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