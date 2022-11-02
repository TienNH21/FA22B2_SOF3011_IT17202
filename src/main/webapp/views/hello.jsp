<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello, ${ data }</h1>
	<form method="POST"
		action="/IT17202/hello">
		<input type="text" name="user" />
		<button>Submit</button>
	</form>
</body>
</html>