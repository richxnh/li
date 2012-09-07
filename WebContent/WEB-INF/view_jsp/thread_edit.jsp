<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑主题：${thread.content}</title>
	</head>
	<body>
		<jsp:include page="account.jsp"/>
		<jsp:include page="header.jsp"/>
		<jsp:include page="links.jsp"/>
		<c:if test="${account == null}">
			<div style="width: 960px;outline:#000000 dashed 1px;">
				<form action="login" method="post">
					<input name="account.username"/>
					<input name="account.password"/>
					<input type="submit" value="login"/>
				</form>
			</div>
		</c:if>
		<c:if test="${account != null}">
			<div style="width: 960px;outline:#000000 dashed 1px;">
				<script charset="utf-8" src="source/plugin/kindeditor-4.1.1/kindeditor-min.js"></script>
				<script charset="utf-8" src="source/plugin/kindeditor-4.1.1/lang/zh_CN.js"></script>
				<script>
					KindEditor.ready(function(K) {
						K.create('#content', {
							themeType : 'simple'
						});
					});
				</script>
				<form action="thread_update" method="POST">
					<input type="hidden" name="thread.id" value="${thread.id}"/>
					<input type="text" name="thread.subject" value="${thread.subject}"/><br/>
					<textarea id="content" name="thread.content" style="width:100%">${thread.content}</textarea><br/>
					<input type="submit" value="保存"/> 
				</form>
			</div>
		</c:if>
		<jsp:include page="footer.jsp"/>
	</body>
</html>