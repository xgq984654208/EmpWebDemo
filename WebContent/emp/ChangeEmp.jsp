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
	<table>
	<caption>XXX员工信息</caption>
		<thead>
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工性别</th>
				<th>员工公种</th>
				<th>员工工资</th>
				<th>员工奖金</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "emp" items = "${empList }" >
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.gender }</td>
					<td>${emp.job }</td>
					<td>${emp.sal }</td>
					<td>${emp.COMM}</td>
					<td><a href = "${pageContext.request.contextPath }/emp/ChangeEmp.action?empno=${emp.empno}&ename=${emp.ename}&gender=${emp.gender}&job=${emp.job}&sal=${emp.sal}&COMM=${emp.COMM}">修改员工信息</a></td>
				</tr>
			</c:forEach>
			
		</tbody>
		</table>
</body>
</html>