<%@page import="com.ty.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Edit User</h3>
<%Student student=(Student)request.getAttribute("object"); %>
<form action="getUser" method="post">
<br>ID
<input type="text" name="Sid"  value="<%=student.getId() %>">
<br>NAME
<input type="text" name="Sname"  value="<%=student.getName() %>">
<br>MAIL
<input type="text" name="Smail"value="<%=student.getMail() %>" >
<br>PASSWORD
<input type="password" name="Spassword" value="<%=student.getPassword() %>">
<br>GENDER
<input type="radio" name="Sgender" value="<%=student.getGender() %>">
<br>PHONE
<input type="number" name="Sphone" value="phone" value="<%=student.getPhone() %>">
<br>AGE
<input type="number" name="Sage" value="age" value="<%=student.getAge() %>">
<br>
<input type="submit" name="submit" value="register">
</form>
</body>
</html>