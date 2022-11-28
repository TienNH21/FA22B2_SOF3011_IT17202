<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sinh viên</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Họ tên</th>
				<th>Email</th>
				<th>Địa chỉ</th>
				<th>SĐT</th>
				<th>Giới tính</th>
				<th>Chuyên ngành</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sv" items="${ ds }">
			<tr>
				<td>${ sv.hoTen }</td>
				<td>${ sv.email }</td>
				<td>${ sv.diaChi }</td>
				<td>${ sv.sdt }</td>
				<td>${ sv.gioiTinh == 1 ? "Nam" : "Nữ" }</td>
				<td>${ sv.chuyenNganhId }</td>
				<td>
					<a
					href="/IT17202/admin/sinh-vien/edit?id=${ sv.id }">
						Cập nhật
					</a>
					<a
						href="/IT17202/admin/sinh-vien/delete?id=${ sv.id }">
						Xóa
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>