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
	<form action="${pageContext.request.contextPath }/emp/SaveChange.action">
		<input type="hidden" name = "empno" value="${emp.empno }"> 
		<input type="hidden" name = "ename" value="${emp.ename }"> 
		<input type="hidden" name = "gender" value="${emp.gender }"> 
		员工编号：${emp.empno }<br><br>
		员工姓名：${emp.ename }<br><br>
		员工性别：${emp.gender }<br><br> 	
		员工工作：<select name = "job">
					<option value = "销售员">销售员</option>
					<option value = "前台">前台</option>
					<option value = "分析师">分析师</option>
					<option value = "文员">文员</option>
					<option value = "经理">经理</option>
				</select><br><br>
		员工工资：<input typy="text" name="sal" value="${emp.sal }"><br><br>
		员工奖金：<input type ="text" name = "COMM" value="${emp.COMM }"><br><br>
		<input type="submit"> 
	</form>
</body>
</html>