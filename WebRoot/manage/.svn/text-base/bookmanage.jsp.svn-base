<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>浏览图书信息</title>
<script type="text/javascript">
	function initEvent() {
		var tableCol = document.getElementById("tableColor");
		var trs = tableCol.getElementsByTagName("tr");
		for ( var i = 1; i <= trs.length; i++) {
			var tr = trs[i];
			if (i % 2 == 0) {
				tr.style.background = "#d3d3d3";
			} else {
				tr.style.background = "white";
			}
		}
	}
</script>
<style type="text/css">
table  thead {
	color: #f8f8f8;
	background-color: #525252;
	font-family: 楷体;
	font-size: 20px;
}

table tr {
	font-family: 楷体;
	font-size: 20px;
}

a:link {
	color: #000000;
	text-decoration: none;
	font-family: 楷体;
	font-size: 20px;
}

a:hover {
	color: #0186ba;
}

a:visited {
	color: khaki;
}

h1 {
	font-family: 华文行楷;
	font-size: 45px;
	color: palegreen;
	text-shadow: 3px 3px 1px #ACAD7D;
}

body {
	background-color: darkslategray;
}
</style>
<body onload="initEvent()">
	${message}
	<a href="${pageContext.request.contextPath}/manage/index.jsp">返回后台首页</a>
	<br/>
	<a href="${pageContext.request.contextPath}/manage/addbook.jsp">添加图书</a>
	<h1 align="center">浏览图书信息</h1>
	<table id="tableColor" cellpadding="10" cellspacing="0" border=2px
		align="center">
		<thead>
			<th>序号</th>
			<th>图书编号</th>
			<th>书名</th>
			<th>图书类别</th>
			<th>图书作者</th>
			<th>是否借出</th>
			<th>图书价格</th>
			<th>操作</th>
		</thead>
		<c:forEach items="${booklist}" var="c" varStatus="vs">
			<tr>
				<td>${vs.index}</td>
				<td>${c.booknum}</td>
				<td>${c.bookname}</td>
				<td>${c.booktype}</td>
				<td>${c.bookauthor}</td>
				<td><c:if test="${c.user_id==0}">否</c:if> <c:if
						test="${c.user_id!=0}">是</c:if></td>
				<td>${c.money}</td>
				<td><a
					href="${pageContext.request.contextPath}/manage/addbook.jsp">添加</a>
					<a
					href="${pageContext.request.contextPath}/manage/updatebook_${c.booknum}.do">修改</a>
					<a
					href="${pageContext.request.contextPath}/manage/deletebook_${c.booknum}.do">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
