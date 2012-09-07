<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div>
	<c:forEach items="${threads}" var="thread">
		<div style="width: 960px; outline: #000000 dashed 1px;">
			<div>
				<a href="member?id=${thread.member_id}">${thread.member_name}</a> :
				<a href="thread?id=${thread.id}">${thread.subject}</a>
			</div>
			<div>${thread.content}</div>
			<div>
				<a href="thread_edit?id=${thread.id}">编辑</a> <a
					href="javascript:if(confirm('确认删除?')){location.href='thread_delete?id=${thread.id}&forum_id=${thread.forum_id}&pn=${page.pageNumber}';}">删除</a>
			</div>
		</div>
	</c:forEach>
</div>