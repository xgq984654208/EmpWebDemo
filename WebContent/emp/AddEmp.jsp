<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/emp/AddEmp.action">
		员工编号：<input type="text" name="empno"><br><br>
		员工姓名：<input type="text" name="ename"><br><br>
		员工性别：<input type="radio" name = "gender" value="男">男
			   <input type = "radio" name = "gender" value ="女">女<br><br> 	
		员工工作：<select name = "job">
					<option value = "销售员">销售员</option>
					<option value = "前台">前台</option>
					<option value = "分析师">分析师</option>
					<option value = "文员">文员</option>
					<option value = "经理">经理</option>
				</select><br><br>
		员工工资：<input typy="text" name="sal"><br><br>
		员工奖金：<input type ="text" name = "COMM"><br><br>
		<input type="submit"> 
	</form>
	
</body>
</html>