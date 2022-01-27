<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="create" method="post">
<br>NAME
<input type="text" name="Sname" >
<br>MAIL
<input type="text" name="Smail" >
<br>PASSWORD
<input type="password" name="Spassword">
<br>GENDER
<input type="radio" name="Sgender">
<br>PHONE
<input type="number" name="Sphone" value="phone">
<br>AGE
<input type="number" name="Sage" value="age">
<br>
<input type="submit" name="submit" value="register">
</form>
</body>
</html>