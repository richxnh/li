<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<c:if test="${account == null}">
		<form action="login" method="post">
			<input name="account.username" /> <input name="account.password" /> <input
				type="submit" value="login" />
		</form>
	</c:if>
	<c:if test="${account != null}">
		欢迎你：
		<a href="member?id=${account.member_id}">${account.username}[${account.member_name}]</a>
		<a href="account_logout">退出</a>
	</c:if>
</div>