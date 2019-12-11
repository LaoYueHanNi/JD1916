<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"
	       +request.getServerName()+":"
	       +request.getServerPort()+path+"/";
	%>

<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.div1 {
	margin-top: 50px;
	margin-left: 150px;
	background-image: url("images/timg.jpg");
	width: 660px;
	height: 550px;
	text-align: center;
	border: solid blue 1px;
}

.div2 {
	padding-top: 100px;
	padding-left: 10px;
}
</style>
</head>
<body>

	<%
	Object obj = request.getParameter("error");
	if(obj!=null){
		out.println("<p style='color:red;'>"+obj+"</p>");
	}
%>
	<div class="div1">
		<form action="loginCl.jsp">
			<div class="div2">
				<span>用户名：</span>&nbsp;&nbsp;&nbsp; <input type="text"
					name="username"> <br> <br> <br> <span>密&nbsp;&nbsp;码：</span>&nbsp;&nbsp;&nbsp;
				<input type="password" name="password"> <br> <br>
				<br> <br> <br> <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置">&nbsp;&nbsp;&nbsp; <span><a
					href="register2.html">还未注册</a></span>
			</div>
		</form>
	</div>
</body>
</html>