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
<title>添加书籍</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<form id="book" method="post" enctype="multipart/form-data" action="admin/save_book.action">
			<fieldset>
				<legend>添加一本书</legend>
				<p>
					<label for="category">类别: </label>
					 <select id="category" name="tid">
					 	<c:forEach items="${cate}" var="ca">
					   		<option value="${ca.tid}">${ca.name}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label for="title">书名: </label> <input id="title" type="text"
						value="" name="bname">
				</p>
				<p>
					<label for="author">作者: </label> <input id="author" type="text"
						value="" name="author">
				</p>
				<p>
					<label for="isbn">ISBN: </label> <input id="isbn" type="text"
						value="" name="isbn">
				</p>
				<p>
					<label for="price">价格: </label> $ <input id="price" type="text"
						value="" name="price">
				</p>
				<p>
					<label for="description">详情: </label>  <input id="description" type="text" name="description" value="${bookOne.description}">
				</p>
				
				<p>
					<label for="pdfs">电子书: </label> 
					<div id="uploadFiles">
						<input type="file" name="pdfsUrl" />
						<input type="file" name="pdfsUrl" />
					</div>
				</p>
				
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" value="添加书籍" tabindex="5">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>