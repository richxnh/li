<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="account.signup" method="POST">
			username:<input type="text" name="account.username" /><br>
			password:<input type="password" name="account.password"/><br/>
			password2:<input type="password" name="password2"/><br/>
			email:<input type="text" name="account.email"/><br/>
			<input type="submit" value="signup"/>
		</form>
	</body>
</html>