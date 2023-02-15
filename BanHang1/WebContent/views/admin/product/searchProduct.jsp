<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
<style type="text/css">
	tr{
	
	border: 1px solid black;
	}
	td{
	
	border: 1px solid black;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			
			<div class="col-md-9 col-sm-12">
				<a href="/BanHang1/admin/product/add" class="btn btn-primary">Them moi</a>
				<form action="/BanHang1/admin/product/search" method="post">
					<input type="text" class="form-control" name="keyword" placeholder="tim theo ten">
					<button type="submit" class="btn btn-danger">Tim</button>
				</form>
				<table>
					<tr>
						<th>Id </th>
						<th>Name</th>
						<th>Price</th>
						<th>Desciption</th>
						<th>Image</th>
						<th>Danh muc</th>
						<th>Option</th>
					
					</tr>
					<tr>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.name }</td>
							<td>${product.price }</td>
							<td>${product.description }</td>
							<td><img src="${product.image }" width="100px" height="100px"  /></td>
							<td>${product.category.name }</td>
							<td><a class="btn btn-success" href="/BanHang1/admin/product/update?pid=${product.getId() }">Sua</a> | <a class="btn btn-danger"
								href="/BanHang1/admin/product/delete?pid=${product.getId() }">Xoa</a></td>
						</tr>
					</c:forEach>
					</tr>
				</table>
			
			</div>
		</div>
	</div>
</body>
</html>