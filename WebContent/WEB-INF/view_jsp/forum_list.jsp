<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="account.jsp" />
	<jsp:include page="header.jsp" />
	<jsp:include page="links.jsp" />
	<div>
		<c:forEach items="${forums}" var="forum">
			<div style="width: 960px; height: 50px; outline: #000000 dashed 1px;">
				<a href="forum?id=${forum.id}">${forum.name}</a>
				<a href="member?id=${forum.member_id}">${forum.member_name}</a>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>