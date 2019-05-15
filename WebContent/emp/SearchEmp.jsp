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
	<form action="${pageContext.request.contextPath }/emp/SearchEmp.action">
		员工姓名:<input type = "text" name ="ename"><br><br>
		员工性别:<input type="text" name = "gender"><br><br>
		员工工作:<select name = "job">
					<option value = "销售员">销售员</option>
					<option value = "前台">前台</option>
					<option value = "分析师">分析师</option>
					<option value = "文员">文员</option>
					<option value = "经理">经理</option>
					<option value = null>null</option>
				</select><br><br>
		是否有奖金:<input type="checkbox" name ="COMM" value="1"><br><br>
		工资区间:<input type="text" name="LeftSal"><em>-</em>
				<input type="text" name="RightSal"><br>
		<input type="submit">
	</form>
	<table>
	<caption>XXX员工信息</caption>
		<thead>
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工性别</th>
				<th>员工公众</th>
				<th>员工工资</th>
				<th>员工奖金</th>
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
					
				</tr>
			</c:forEach>
			
		</tbody>
		</table>
</body>
</html>