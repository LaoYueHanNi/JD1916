<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>last_name</th>
			<th>dept_id</th>
		</tr>
		<%
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "briup", "briup");
			Statement statement = conn.createStatement();
			String sql = "select id,last_name,dept_id from s_emp";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int dept_id = rs.getInt(3);
		%>
		<tr>
			<td><%=id%></td>
			<td><%=name%></td>
			<td><%=dept_id%></td>
		</tr>
		<% }%>
	</table>
</body>
</html>