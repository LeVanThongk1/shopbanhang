<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<a href="/BanHang1/admin/category/add" class="btn btn-primary">Them moi</a>
				
				<div id="dang ki" class="container">
    <form action="/BanHang1/admin/category/add" method="POST"  id="dangnhapne" >
       	ten: <input type="text" name="name">
       	<input type="submit" value="dang ki">
    </form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>