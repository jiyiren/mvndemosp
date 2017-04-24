<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<h3 align="center">登录页面</h3>
	<div align="center">
		<h4>登录</h4>
		<form action="login" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录" /></td>
					<td><input type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
		<c:if test="${not empty requestScope.loginResult }">
			<p style="color: red;">${requestScope.loginResult}</p>
		</c:if>
	</div>
	<hr />
	<p align="center">
		<a href="register">注册</a>
	</p>
</body>
</html>