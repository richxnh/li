<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<a href="forum?id=${thread.forum_id}">${thread.forum_name}</a>
</div>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<div>${thread.member_name}: ${thread.subject}</div>
	<div>${thread.content}</div>
	<div>
		<a href="thread_edit?id=${thread.id}">编辑</a> <a
			href="javascript:if(confirm('确认删除?')){location.href='thread_delete?id=${thread.id}&forum_id=${thread.forum_id}&pn=${page.pageNumber}';}">删除</a>
	</div>
</div>