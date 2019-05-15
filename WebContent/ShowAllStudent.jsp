<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 2px solid black;
}
</style>
</head>

<body>
	<c:forEach var="stulist" items="${stuMap }">
		<c:set var="sl" value="${stulist.value }"></c:set>
			<table>
				<option>${stulist.key}班级学生信息</option>
				<thead>
					<tr>
						<th>姓名</th>
						<th>年龄</th>
						<th>性别</th>
					</tr>

				</thead>

				<tbody>
					<c:forEach var="stu" items="${sl }">
						<tr>
							<td>${stu.name }</td>
							<td>${stu.age }</td>
							<td>${stu.gender }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
	
	</c:forEach>

</body>
</html>