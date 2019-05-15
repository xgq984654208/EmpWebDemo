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
				<th>员工公众</th>
				<th>员工工资</th>
				<th>员工奖金</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "emp" items = "${pBean.beanList }" >
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
		<div>
			<a href = "${pageContext.request.contextPath}/emp/PageEmp.action?pagecode=1">首页</a>
			<c:if test="${pBean.pagecode>1 }">
			<a href = "${pageContext.request.contextPath}/emp/PageEmp.action?pagecode=${pBean.pagecode-1}">上一页</a>
			</c:if>
			
			<c:set var = "begin" value = "${pBean.pagecode-5 }"></c:set>
			<c:set var = "end" value = "${pBean.pagecode+4 }"></c:set>
				
			<c:if test="${pBean.totalpage<10 }">
				<c:set var = "begin" value = "${1 }"></c:set>
				<c:set var = "end" value = "${pBean.totalpage }"></c:set>
			</c:if>
			<c:if test="${begin<1 }">
				<c:set var ="begin" value = "${1 }"></c:set>
				<c:set var ="end" value = "${10 }"></c:set>
			</c:if>
			<c:if test="${pBean.pagecode>=pBean.totalpage }">
				<c:set var = "begin" value = "${pBean.totalpage-9}"></c:set>
				<c:set var ="end" value = "${pBean.totalpage}"></c:set>
			</c:if>
			<c:forEach var = "i" begin="${begin}" end = "${end}">
				<c:if test="${pBean.pagecode!=i }">
				[<a href = "${pageContext.request.contextPath}/emp/PageEmp.action?pagecode=${i}">${i }</a>]
				</c:if>
				
				<c:if test="${pBean.pagecode==i }">
					[${i }]
				</c:if>
			</c:forEach>
			<c:if test="${pBean.pagecode<pBean.totalpage }">
			<a href = "${pageContext.request.contextPath}/emp/PageEmp.action?pagecode=${pBean.pagecode+1}">下一页</a>
			</c:if>
			<a href = "${pageContext.request.contextPath}/emp/PageEmp.action?pagecode=${pBean.totalpage}">尾页</a>
			
			
			
			第${pBean.pagecode }页
			共${pBean.totalpage}页
		</div>
</body>
</html>