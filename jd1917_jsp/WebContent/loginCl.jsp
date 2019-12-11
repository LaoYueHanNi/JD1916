<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		if("briup".equals(name)&&"123".equals(pwd)){
			session.setAttribute("name", "briup");
			//response.sendRedirect("success.jsp");
	%>
	<jsp:include page="success.jsp"></jsp:include>
	<% 
		}else{
			request.setAttribute("error", "用户或密码错误");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%		
		}
	%>
</body>
</html>