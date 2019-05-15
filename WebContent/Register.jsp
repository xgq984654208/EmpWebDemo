<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/FirstWeb/Register" name="myform" method="get">
			姓名：<input type="text" name="username" id="" value="zhangsan" /><br />
			密码:   <input type="password" name="password" /><br />
			性别：<input type="radio" name="gender" value="male" checked="checked" />男 &nbsp;
			           <input type="radio" name="gender" value="female" />女 &nbsp; <br />
			爱好：<input type="checkbox" name="hobby" value="football" /> 足球
					  <input type="checkbox" name="hobby" value="basketball" /> 篮球
					  <input type="checkbox" name="hobby" value="baseball" /> 排球
				   	  <input type="checkbox" name="hobby" value="football" /> 足球<br />
				   	  
			地址：<select name="city">
						<option value="bj">北京</option>
						<option value="tj">天津</option>
						<option value="sh">上海</option>
						<option value="cq">重庆</option>
			</select>
							<br />
				   	  
			邮箱：<input type="text" name="email" id="" value="" /><br />
			备注：<textarea  cols="30" rows="5" name="te" >
				
			</textarea><br/>
		   上传头像：<input type = "file"  name="photo"/><br />
			<input type="submit" value="注册"  />
			<input type="reset" value="重置" />
			<input type="button" value="button" />
		
		</form>
</body>
</html>