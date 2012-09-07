<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>板块：${forum.name}</title>
	</head>
	<body>
		<jsp:include page="account.jsp"/>
		<jsp:include page="header.jsp"/>
		<jsp:include page="links.jsp"/>
		<jsp:include page="forum_page.jsp"/>
		<jsp:include page="forum_basic.jsp"/>		
		<jsp:include page="thread_list.jsp"/>
		<jsp:include page="forum_page.jsp"/>
		<jsp:include page="thread_add.jsp"/>
		<jsp:include page="footer.jsp"/>
	</body>
</html>