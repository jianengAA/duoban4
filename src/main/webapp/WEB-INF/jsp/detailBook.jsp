<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false" %>
   	  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%	
    	String path=request.getContextPath();
    	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath %>" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详情</title>
</head>
<body>
<div id="global">
	<fieldset>
		<legend>${book.bname }</legend>
		<p>
			<div id="info"><label>类别：</label>${book.category.name }</div>
		</p>
		<p>
			<div id="info"><label>ISBN：</label>${book.isbn }</div>
		</p>
		<p>
			<div id="info"><label>作者：</label>${book.author }</div>
		</p>
		<p>
			<div id="info"><label>价格：</label>${book.price }</div>
		</p>
		<p id="buttons">
			<a href="javascript:history.go(-1)">返回上一级</a>
		</p>
	</fieldset>
</div>
</body>
</html>