<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<a href="thread?id=${thread.id}&pn=1">首页</a> / 
	<a href="thread?id=${thread.id}&pn=${page.previous}">上一页</a> / 
	<a href="thread?id=${thread.id}&pn=${page.next}">下一页</a> / 
	<a href="thread?id=${thread.id}&pn=${page.pageCount}">末页</a> /
	第${page.pageNumber}页/共${page.pageCount}页
</div>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<script type="text/javascript"
		src="http://www.osctools.net/js/jquery/jquery-1.7.2.js"></script>
	<script type="text/javascript"
		src="http://www.osctools.net/uploads/jquery/pagination/jquery.myPagination.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#demo2").myPagination({
				currPage : 1,
				pageCount : 100,
				pageSize : 5,
				cssStyle : 'sabrosus'
			});
		});
	</script>
	<div id="demo2"></div>
</div>