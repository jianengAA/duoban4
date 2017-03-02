<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>.
<meta charset="UTF-8">
<title>豆瓣</title>

	<!-- <style type="text/css" >@import url(css/main.css); </style> -->
</head>
<body>

	操作成功
	书本:${book} <br/>
	
	<table>
	
		<c:forEach items="${book}" var="list">
	   		<tr>
	   			<td>${list.tid}</td>
				<td>${list.bname}</td>
				<td>${list.isbn}</td>
				<td>${list.author}</td>
				<td>${list.price}</td>
				<td><a href="edit_book/2">编辑</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	
</body>
</html>