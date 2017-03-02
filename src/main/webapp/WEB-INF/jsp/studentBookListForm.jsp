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
<title>源辰信息游戏公司-豆瓣</title>
<style type="text/css">
@import url(css/main.css);
</style>

<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<script type="text/javascript";charset="utf-8">
	$(document).ready(
		function(){
			$("#category").change(
				//路径：findBookByCategory/1
				function(){
				$.post("findBookByCategory/"+$(this).val(),function(json){
					var obj = $.parseJSON(json);
					$("#bookList").html("");
					for(var i=0;i<obj.length;i++){
						var o = obj[i];
						$("#bookList").append(
								"<tr><td>" + o.category.name
								+ "</td><td>"+ o.bname
								+ "</td><td>"+ o.isbn
								+ "</td><td>"+ o.author
								+ "</td><td>"+ o.price
								+ "</td><td><a href='toDetailForm/"+o.bid+".action'>详情</a> <a href='toRankBookForm/"+o.bid+".action'>投票</a></td></tr>");
					}
				});	
				});
		});

</script>



</head>
<body>
	<div id="global">
		<h1>源辰信息有限公司</h1>
		<h2>豆瓣书屋</h2>
	
	筛选:<select id="category" name="tid">	
			<option value="-1">所有类别</option>
				<c:forEach items="${cate}" var="ca">
					 <option value="${ca.tid}">${ca.name}</option>
				</c:forEach>
		</select>
		
		<table>
			<thead>
				<tr>
					<th>类别</th>
					<th>书名</th>
					<th>ISBN</th>
					<th>作者</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>	
				
			<tbody id="bookList">	
			<c:forEach items="${book}" var="list">
		   		<tr>
		   			<td>${list.category.name}</td>
					<td>${list.bname}</td>
					<td>${list.isbn}</td>
					<td>${list.author}</td>
					<td>${list.price}</td>
					<td><a href="toDetailForm/${list.bid}.action">详情</a> <a href="toRankBookForm/${list.bid}.action">投票</a></td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>