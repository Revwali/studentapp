<%@page import="com.ty.studentapp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2px">
<tr>
<td>name</td>
<td>mail</td>
<td>phone</td>
<td>gender</td>
<td>age</td>
</tr>
<% List<Student> list=(List<Student> )request.getAttribute("students"); 
if(list != null){
for(Student student : list) {
	%>
	
	<tr>
		
		<td><%=student.getName() %></td>
		<td><%=student.getMail() %></td>
		<td><%=student.getPhone() %></td>
		<td><%=student.getAge() %></td>
		<td>
		<a href="delete?id=<%=student.getId()%>">delete</a></td>
		<td>
		<a href="getOne?id=<%=student.getId()%>">edit</a></td>
	</tr>
	
	
<%
}
}
%>
</table>
</body>
</html>