<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div style="width: 960px; outline: #000000 dashed 1px;">
	<div>Member ID:<input readonly="readonly" value="${member.id}"></div>
	<div>Member Name:<input readonly="readonly" value="${member.name}"></div>
	<div>Account ID:$<input readonly="readonly" value="{member.account_id}"></div>
	<div>Account Username:<input readonly="readonly" value="${member.account_username}"></div>
	<div>Account Password:<input readonly="readonly" value="${member.account_password}"></div>
	<div>Account Email:<input readonly="readonly" value="${member.account_email}"></div>
</div>