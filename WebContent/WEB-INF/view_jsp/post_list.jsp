<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div>
	<c:forEach items="${posts}" var="post">
		<div style="width: 960px; outline:#000000 dashed 1px;">
			<div>
				${post.member_name}:${post.subject}
			</div>
			<div>
				${post.content}
			</div>
			<div>
				<a href="post_edit?id=${post.id}">编辑</a>
				<a href="javascript:if(confirm('确认删除?')){location.href='post_delete?id=${post.id}&thread_id=${post.thread_id}&pn=${page.pageNumber}';}">删除</a>
			</div>
		</div>
	</c:forEach>
</div>