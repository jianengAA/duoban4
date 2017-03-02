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
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>修改书籍</title>
<style type="text/css">
/* @import url(css/main.css); */
</style>
<script type="text/javascript">
//刷验证码
function loadImage(){
	var img = document.getElementById("randImg");
	img.src="imageCode.jsp?r="+Math.random();
}
</script>
</head>
<body>
	<c:if test="${msgmsg!='' }">
		<font style="color:red"><c:out value="${errmsg }"></c:out></font>
	</c:if>
	
	<form action="adminLogin.action" method="post">
		<fieldset>
			<legend>后台管理登录</legend>
			<p>用户名:<input type="text" name="uname"/></p>
			<p>密码:<input type="password" name="password"/></p>
			<p>验证码:<input type="text" name="validateCode"/>
			<img id="randImg" border=0 src="imageCode.jsp">
			<a href="javascript:loadImage();">换一张</a></p>
			<p><input type="submit" value="登录"></p>
			
		</fieldset>
	</form>
	
</body>
</html>