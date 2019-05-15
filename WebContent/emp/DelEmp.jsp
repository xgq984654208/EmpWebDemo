<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/emp/DelEmp.action">
	<table>
	<caption>XXX员工信息</caption>
		<thead>
			<tr>
				<th></th>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工性别</th>
				<th>员工公众</th>
				<th>员工工资</th>
				<th>员工奖金</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "emp" items = "${empList }" >
				<tr>
					<td><input type = "checkbox" name = "check" value = "${emp.empno }"></td>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.gender }</td>
					<td>${emp.job }</td>
					<td>${emp.sal }</td>
					<td>${emp.COMM}</td>
					<td><a href = "${pageContext.request.contextPath }/emp/DelEmp.action?check = ${emp.empno}">删除</a></td>
					<td><a href = "${pageContext.request.contextPath }/emp/DelEmp.action?check = ${emp.empno}">修改</a></td>
					
				</tr>
			</c:forEach>
			
		</tbody>
		</table>
			<input type = "submit">
		</form>
</body>
</html>