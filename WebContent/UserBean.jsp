<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>UserBean</title>
<style type="text/css">


</style>
</head>
<body>
	<table>
		<tr>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.classNum}</td>
			<td>${user.age}</td>
		</tr>
	
	
	</table>
</body>
</html>