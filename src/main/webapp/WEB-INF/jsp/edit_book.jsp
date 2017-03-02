<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
	
<%
	//将相对路径，全部替换成绝对路径
	String path = request.getContextPath();  //  /duoban 
	String basePath = request.getScheme()+ "://" +request.getServerName() + ":" +request.getServerPort() +path +"/";   
%>
	


<html>
<head>
<base href="<%=basePath%>">
<title>修改书籍</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<form id="book" method="post" enctype="multipart/form-data" action="admin/saveEdit_book.action">
			<fieldset>
				<legend>修改一本书</legend>
				<%-- <input type="hidden" name="bid" value="${bookOne.bid}">  --%>
				  <form:hidden path="bookOne.bid" />
				<p>
					<label for="category">类别: </label>
					 <select id="category" name="tid"">
						<c:forEach items="${cate}" var="ca">
					   		<option value="${ca.tid}">${ca.name}</option>
						</c:forEach>
						
					</select>
				</p>
				<p>
					<label for="title">书名: </label> <input id="title" type="text" name="bname" value="${bookOne.bname}">
				</p>
				<p>
					<label for="author">作者: </label> <input id="author" type="text" name="author" value="${bookOne.author}">
				</p>
				<p>
					<label for="isbn">ISBN: </label> <input id="isbn" type="text" name="isbn" value="${bookOne.isbn}">
				</p>
				<p>
					<label for="price">价格: </label> $ <input id="price" type="text" name="price" value="${bookOne.price}">
				</p>
				<p>
					<label for="description">详情: </label>  <input id="description" type="text" name="description" value="${bookOne.description}">
				</p>
				
				<p>
					<label for="pdfs">已经上传的电子书: </label> <br/>
					<ul>
						<c:forEach items="${bookOne.pdfsStringList }" var="pdfUrl">
							<li><a href="${pdfUrl }">下载电子书</a></li>
						</c:forEach>
					</ul>
					
					<div id="uploadFiles">
						重新上传电子书:<input type="file" name="pdfsUrl" />
						<input type="file" name="pdfsUrl" />
					</div>
				</p>
	

				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> 
					<input id="submit" type="submit" value="修改书籍" tabindex="5">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>