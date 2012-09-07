<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主题：${thread.subject}</title>
	</head>
	<body>
		<jsp:include page="account.jsp"/>
		<jsp:include page="header.jsp"/>
		<jsp:include page="links.jsp"/>
		<jsp:include page="thread_page.jsp"/>
		<jsp:include page="thread_basic.jsp"/>
		<jsp:include page="post_list.jsp"/>
		<jsp:include page="thread_page.jsp"/>
		<jsp:include page="post_add.jsp"/>
		<jsp:include page="footer.jsp"/>
	</body>
</html>