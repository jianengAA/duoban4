<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%
	//将相对路径，全部替换成绝对路径
	String path = request.getContextPath();  //  /duoban 
	String basePath = request.getScheme()+ "://" +request.getServerName() + ":" +request.getServerPort() +path +"/";   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>书籍列表</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<h1>书籍列表</h1>
		<a href="admin/toinput_book.action">添加书</a>
		<table>
			<tbody>
				<tr>
					<th>类别</th>
					<th>书名</th>
					<th>ISBN</th>
					<th>作者</th>
					<th>价格</th>
					<th></th>
				</tr>
				
			<c:forEach items="${book}" var="list">
		   		<tr>
		   			<td>${list.category.name}</td>
					<td>${list.bname}</td>
					<td>${list.isbn}</td>
					<td>${list.author}</td>
					<td>${list.price}</td>
					<td><a href="admin/toedit_book/${list.bid}.action">编辑</a></td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>