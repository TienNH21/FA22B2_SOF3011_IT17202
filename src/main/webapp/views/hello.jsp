<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello,
		<c:if test="${ !empty data }">${ data }</c:if>
	</h1>
	<c:set var="diem" value="4" scope="page" ></c:set>
	<c:choose>
		<c:when test="${ diem < 5 }">
			<h2>Trượt môn</h2>
		</c:when>
		<c:when test="${ diem < 7 }">
			<h2>Trung bình</h2>
		</c:when>
		<c:when test="${ diem < 9 }">
			<h2>Khá</h2>
		</c:when>
		<c:otherwise>
			<h2>Ong vàng</h2>
		</c:otherwise>
	</c:choose>
	
	<form method="POST"
		action="/IT17202/hello">
		<input type="text" name="user" />
		<button>Submit</button>
	</form>
	
	<ul>
		<c:forEach items="${ ds }" var="item">
			<li>${ item }</li>
		</c:forEach>
	</ul>
</body>
</html>