<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${forum.name}<br/><br/><br/>
	<c:forEach items="${threads}" var="thread">
		<a href="thread.get?id=${thread.id}">${thread.subject}</a><br/>
	</c:forEach>
	<div>
		<a href="forum.get?id=${forum.id}&pn=1">首页</a> / 
		<a href="forum.get?id=${forum.id}&pn=${page.previous}">上一页</a> / 
		<a href="forum.get?id=${forum.id}&pn=${page.next}">下一页</a> / 
		<a href="forum.get?id=${forum.id}&pn=${page.pageCount}">末页</a> /
		第${page.pageNumber}页/共${page.pageCount}页 
	</div>
	<form action="thread.save" method="POST">
		<input type="hidden" name="thread.forum_id" value="${forum.id}"/>
		<input type="text" name="thread.member_id" value="60"/><br/>
		<input type="text" name="thread.subject"/><br/>
		<textarea name="thread.content"></textarea><br/>
		<input type="submit" value="提交"/> 
	</form>
</body>
</html>