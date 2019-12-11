<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  恭喜<%out.println(session.getAttribute("name")); %>起飞成功
	  ${name}
</body>
</html>