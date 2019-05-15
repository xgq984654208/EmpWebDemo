<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${user}"></c:out>
	<c:set var="key" value = "value" scope="session"> </c:set>
	<table>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${userlist }">
				<tr>
					<td><c:out value="${item.name }"></c:out></td>
					<td><c:out value="${item.gender }"></c:out></td>
					<td><c:out value="${item.age }"></c:out></td>
				</tr>
			
			</c:forEach>
		</tbody>
	
	</table>
</body>
</html> 