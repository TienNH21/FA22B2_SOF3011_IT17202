<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/IT17202/admin/sinh-vien/store">
		<div>
			<label>Họ tên</label>
			<input type="text" name="hoTen" />
		</div>
		<div>
			<label>Email</label>
			<input type="email" name="email" />
		</div>
		<div>
			<label>SĐT</label>
			<input type="text" name="sdt" />
		</div>
		<div>
			<label>Địa chỉ</label>
			<input type="text" name="diaChi" />
		</div>
		<div>
			<label>Giới tính</label>
			<input type="radio" name="gioiTinh" value="1" />
			<label>Nam</label>
			<input type="radio" name="gioiTinh" value="0" />
			<label>Nữ</label>
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="password" />
		</div>
		<div>
			<label>Chuyên ngành</label>
			<select name="chuyenNganh">
				<option disable selected>Chọn chuyên ngành</option>
				<option value="1">PTPM</option>
				<option value="2">TKTW</option>
				<option value="3">LTMT</option>
			</select>
		</div>
		<div>
			<button>Đăng ký</button>
		</div>
	</form>
</body>
</html>