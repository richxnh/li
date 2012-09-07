<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
		<form action="post.save" method="POST">
			<input type="hidden" name="post.status" value="1"/>
			<input type="hidden" name="post.thread_id" value="${thread.id}"/>
			<input type="hidden" name="post.member_id" value="1"/>
			<input type="text" name="post.subject"/><br/>
			<textarea id="content" name="post.content" style="width:100%"></textarea><br/>
			<input type="submit" value="提交"/> 
		</form>
	</div>
</c:if>