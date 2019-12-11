<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Count2.jsp" method="post">
		<input type="text" name="addOne"> + <input type="text"
			name="addTwo"> <input type="submit" value="等于"><br>
		<br>
	</form>
	<%
	if(request.getMethod().equals("post")){
		
	double one = Double.parseDouble(request.getParameter("addOne"));
	double two = Double.parseDouble(request.getParameter("addTwo"));
	out.println("和为:"+(one+two));
	}
	%>
</body>
</html>