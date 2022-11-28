<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST"
		action="/IT17202/admin/sinh-vien/update?id=${ sv.id }">
		<div>
			<label>Họ tên</label>
			<input type="text" name="hoTen" value="${ sv.hoTen }" />
		</div>
		<div>
			<label>Email</label>
			<input type="email" name="email" value="${ sv.email }" />
		</div>
		<div>
			<label>SĐT</label>
			<input type="text" name="sdt" value="${ sv.sdt }" />
		</div>
		<div>
			<label>Địa chỉ</label>
			<input type="text" name="diaChi" value="${ sv.diaChi }" />
		</div>
		<div>
			<label>Giới tính</label>
			<input type="radio" name="gioiTinh" value="1"
				${ sv.gioiTinh == 1 ? "checked" : "" }
			/>
			<label>Nam</label>
			<input type="radio" name="gioiTinh" value="0"
				${ sv.gioiTinh == 0 ? "checked" : "" }
			/>
			<label>Nữ</label>
		</div>
		<div>
			<label>Chuyên ngành</label>
			<select name="chuyenNganh">
				<option disable selected>Chọn chuyên ngành</option>
				<option value="1"
				${ sv.chuyenNganhId == 1 ? "selected" : "" }
				>PTPM</option>
				<option value="2"
				${ sv.chuyenNganhId == 2 ? "selected" : "" }
				>TKTW</option>
				<option value="3"
				${ sv.chuyenNganhId == 3 ? "selected" : "" }
				>LTMT</option>
			</select>
		</div>
		<div>
			<button>Cập nhật</button>
		</div>
	</form>
</body>
</html>