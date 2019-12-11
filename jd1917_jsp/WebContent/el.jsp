<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el表达式 -->
	${4+7 }<br>
	<%out.println(4+7); %><br>
	<% 
		String name = "xiha";
	
	%>
	${empty name }<br>
	
	
	<!-- pageContext隐含对象 -->
	${pageContext}<br>
	
	
	<!-- el中的四大范围 -->
	<%
		pageContext.setAttribute("msg", "page");
		request.setAttribute("msg1", "request");
		session.setAttribute("msg", "session");
		application.setAttribute("msg", "application");
	%>
	page:${pageScope.msg }<br>
	request:${requestScope.msg1 }<br>
	session:${sessionScope.msg }<br>
	application:${applicationScope.msg }<br>
	
	${msg }<br>
	<a href="test.jsp">跳转</a>
	
	<!-- initparam隐含对象,取web.xml中的全局参数 -->
	${initParam.msg}<br>
	
	<!-- param隐含对象 -->
	(获取form表单中的数据)参数: ${init.name}<br>
	
	
	<!-- paramValues隐含对象 -->
	hobby:${paramValues.hobby }<br>
	
	<!-- cookie隐含对象 -->
</body>
</html>