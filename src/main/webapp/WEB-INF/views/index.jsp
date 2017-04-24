<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.jiyiren.mvnspdemo.bean.domodel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello Index</h3>
	<%
		UserDO muser=(UserDO)session.getAttribute("user");
	%>
	用户账号信息：用户ID：${sessionScope.user.id} ; 用户名：<%=muser.getUserName() %><br><br>
</body>
</html>