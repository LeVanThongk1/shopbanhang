<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Category</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<form action="/BanHang1/admin/category/update" method="post">
					<div class="form-group">
						<label>ID:</label> <input readonly="readonly" class="form-control" name="id" value="${category.getId()}" type="text" placeholder="Nhap Id">
					</div>
					<div class="form-group">
						<label>Tên:</label> <input value="${category.getName()}" class="form-control" type="text" name="name" placeholder="Nhap ten">
					</div>
					<div>
						<input class="btn btn-primary" type="submit" value="Update">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>