<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<a href="forum?id=${forum.id}&pn=1">首页</a> / <a
		href="forum?id=${forum.id}&pn=${page.previous}">上一页</a> / <a
		href="forum?id=${forum.id}&pn=${page.next}">下一页</a> / <a
		href="forum?id=${forum.id}&pn=${page.pageCount}">末页</a> /
	第${page.pageNumber}页/共${page.pageCount}页
</div>