<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    errorPage="error.jsp"
    import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--   声明元素:写java代码 写成员变量,成员方法,成员内部类 -->
	<%! 
		int i = 10;
		public int getA(){
			return 0;			
		}
		class Test{
			private String name ="sia";
			public String getName(){
				return name;
			}
		}
	%>
	<!--  表达式元素:写Java代码 -->
	<%="张三几把蛋" %><br>
	<%=5+3 %><br>
	<%= new Test().getName() %><br>
	<!-- jsp的九种隐含对象 -->
	request : <%=request %><br>
	exception : <%=exception %><br>
	<!-- 脚本元素除了成员变量其他代码都可以写 -->
	<% 
		int  k = 10;
		for(int i = 0;i<10;i++){
			out.println(i);
		}
		new Date();
	%>
	<%@include file ="footer.jsp" %>
</body>
</html>