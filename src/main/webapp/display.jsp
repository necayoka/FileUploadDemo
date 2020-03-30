<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display</title>
</head>
<body>

<h1>Dispaly</h1>

<%-- ${slika.name} --%>

<img id="photo" src="data:image/jpeg;base64,${slika}" />

</body>
</html>