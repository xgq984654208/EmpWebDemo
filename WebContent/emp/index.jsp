<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理系统</title>
<link rel="stylesheet"  href = "${pageContext.request.contextPath}/css/emp_index.css" type="text/css">
<style >
	
</style>
</head>
<body>
	<div class = "header">
		<h2>XXX员工管理系统</h2>
	</div>
	
		<div class = "nav-list">
		<ul>
			<li class = "nav-list-li"><a href = "SearchEmp.jsp" target="content-ifram">查看员工信息</a></li>
			<li class = "nav-list-li"><a href = "${pageContext.request.contextPath}/emp/InitEmp.action?operate=del" target="content-ifram">删除员工信息</a></li>
			<li class = "nav-list-li"><a href = "AddEmp.jsp" target="content-ifram">录入员工信息</a></li>
			<li class = "nav-list-li"><a href = "${pageContext.request.contextPath}/emp/InitEmp.action?operate=change" target="content-ifram">更改员工信息</a></li>
			<li class = "nav-list-li"><a href = "${pageContext.request.contextPath}/emp/PageEmp.action?pagecode=1" target="content-ifram">分页显示员工信息</a></li>
			<li class = "nav-list-li"><a href = "${pageContext.request.contextPath}/emp/OutLogin.action" >退出登录</a></li>
			
		</ul> 
	</div>
	<div class = "content">
		<iframe name = "content-ifram" class = "con-iframe"></iframe>
	</div>
	
	
</body>
</html>