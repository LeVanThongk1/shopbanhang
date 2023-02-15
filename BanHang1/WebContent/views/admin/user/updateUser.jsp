<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<form action="/BanHang1/admin/user/update" method="post" >
					<div class="form-group">
						<label>ID:</label> <input name="id" value="${user.id}" class="form-control" type="text" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Tên:</label> <input value="${user.name}" class="form-control" type="text" name="name" placeholder="Nhap ten">
					</div>
					<div class="form-group">
						<label>Tài khoản:</label> <input value="${user.username}" class="form-control" type="text" name="username" placeholder="Nhap tai khoản">
					</div>
					<div class="form-group">
						<label>Mat khau:</label> <input value="${user.password}" class="form-control" type="password" name="password" placeholder="Nhap mk">
					</div>
					<div class="form-group">
						<label>Tuổi:</label> <input value="${user.age}" class="form-control" type="number" name="age" placeholder="Nhập tuổi">
					</div>
					<div class="form-group">
						<label>Gender : </label>
						<c:choose>
							<c:when test="${user.getGender().equals('nam')}">
								<input type="radio" name="gender" value="nam" checked="checked">Nam
								<input type="radio" name="gender" value="nu">Nu
							</c:when>
							<c:otherwise>
								<input type="radio" name="gender" value="nam">Nam
								<input type="radio" name="gender" value="nu" checked="checked">Nu
			  				</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<label>Role: </label> <select name="role" class="form-control">
							<c:if test="${user.role=='ROLE_ADMIN'}">
								<option value="ROLE_MEMBER">ROLE_MEMBER</option>
								<option value="ROLE_ADMIN" selected>ROLE_ADMIN</option>
							</c:if>
							<c:if test="${user.role=='ROLE_MEMBER'}">
								<option value="ROLE_MEMBER" selected>ROLE_MEMBER</option>
								<option value="ROLE_ADMIN">ROLE_ADMIN</option>
							</c:if>
						</select>
					</div>
					<div class="form-group">
						<label>Ảnh URL:</label> <input value="${user.image}" name="image" class="form-control" type="text"></input>
					</div>
					<div class="form-group">
						<input class="btn btn-primary" type="submit" value="update">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>