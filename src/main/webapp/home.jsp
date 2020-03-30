<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>

<h1>File Upload</h1>

<form action="upload" method="post" enctype="multipart/form-data">
	<input type="text" name="name"><br>
	<input type="file" name="file"><br>
	<input type="submit"><br><br>
</form>

<form action="getSlikaForm">
	<input type="submit" value="getSlikaForm">
</form>

</body>
</html>