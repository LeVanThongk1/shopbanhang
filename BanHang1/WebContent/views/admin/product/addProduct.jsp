<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD PRODUCT</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<form action="/BanHang1/admin/product/add" method="post" 
				enctype="multipart/form-data" >
					<div class="form-group">
						<label>Tên:</label> <input class="form-control" type="text" name="name" placeholder="Nhap ten">
					</div>
					<div class="form-group">
						<label>Giá:</label> <input class="form-control" type="text" name="price" placeholder="Nhap gia">
					</div>
					<div class="form-group">
						<label>description:</label> <input class="form-control" type="text" name="description" placeholder="Nhap description">
					</div>
					<div class="form-group">
						<label>Image File:</label> 
						<input class="form-control" type="file" name="imageFile" accept="image/*">
					</div>
					<div class="form-group">
						<label>Category:</label> 
						<select class="form-control" name="categoryId">
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.id}">${category.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input class="btn btn-primary" type="submit" value="Update">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>